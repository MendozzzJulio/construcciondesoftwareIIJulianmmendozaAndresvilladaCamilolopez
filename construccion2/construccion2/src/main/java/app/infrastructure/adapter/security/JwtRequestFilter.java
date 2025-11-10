package app.infrastructure.adapter.security;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import app.domain.entities.User;
import app.domain.entities.enums.Role;
import app.domain.services.AuthenticationService;

/**
 * Filtro para procesar tokens JWT en cada petición
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
                                  FilterChain chain) throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;

        // JWT Token está en la forma "Bearer token". Remover Bearer y obtener solo el token
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = jwtUtil.extractUsername(jwtToken);
            } catch (Exception e) {
                logger.warn("No se pudo obtener el username del JWT Token: " + e.getMessage());
            }
        }

        // Una vez que obtenemos el token, validamos
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            // Si el token es válido, configuramos Spring Security para establecer la autenticación
            if (jwtUtil.validateToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                    .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Después de establecer la autenticación en el contexto, especificamos
                // que el usuario actual está autenticado. Así pasa los filtros de Spring Security
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                // Establecer el usuario en nuestro AuthenticationService
                try {
                    User currentUser = userDetailsService.getUserByUsername(username);
                    authenticationService.setCurrentUser(currentUser);
                } catch (Exception e) {
                    logger.error("Error al establecer usuario en AuthenticationService: " + e.getMessage());
                }
            }
        }
        chain.doFilter(request, response);
    }
}
