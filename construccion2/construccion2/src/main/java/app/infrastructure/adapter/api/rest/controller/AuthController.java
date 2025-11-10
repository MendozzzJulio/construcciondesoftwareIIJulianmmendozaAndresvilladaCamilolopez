package app.infrastructure.adapter.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import app.domain.entities.User;
import app.infrastructure.adapter.api.rest.dto.request.LoginRequest;
import app.infrastructure.adapter.api.rest.dto.response.ApiResponse;
import app.infrastructure.adapter.api.rest.dto.response.LoginResponse;
import app.infrastructure.adapter.security.CustomUserDetailsService;
import app.infrastructure.adapter.security.JwtUtil;

/**
 * Controlador para operaciones de autenticación
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Endpoint para login de usuarios
     */
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Autenticar usuario
            authenticate(loginRequest.getUsername(), loginRequest.getPassword());

            // Cargar detalles del usuario
            final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
            
            // Obtener información completa del usuario
            final User user = userDetailsService.getUserByUsername(loginRequest.getUsername());

            // Generar token JWT
            final String token = jwtUtil.generateToken(
                userDetails.getUsername(), 
                user.getRole().name(), 
                user.getId()
            );

            // Crear respuesta
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken(token);
            loginResponse.setUsername(user.getUsername());
            loginResponse.setRole(user.getRole().name());
            loginResponse.setUserId(user.getId());
            loginResponse.setName(user.getName() + " " + user.getLastName());

            return ResponseEntity.ok(ApiResponse.success("Login exitoso", loginResponse));

        } catch (DisabledException e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Usuario deshabilitado"));
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Credenciales inválidas"));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error en el login: " + e.getMessage()));
        }
    }

    /**
     * Endpoint para validar token
     */
    @PostMapping("/validate")
    public ResponseEntity<ApiResponse<String>> validateToken(@RequestHeader("Authorization") String token) {
        try {
            if (token != null && token.startsWith("Bearer ")) {
                String jwtToken = token.substring(7);
                String username = jwtUtil.extractUsername(jwtToken);
                
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                
                if (jwtUtil.validateToken(jwtToken, userDetails)) {
                    return ResponseEntity.ok(ApiResponse.success("Token válido"));
                }
            }
            
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Token inválido"));
                
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al validar token: " + e.getMessage()));
        }
    }

    /**
     * Endpoint para obtener información del usuario actual
     */
    @GetMapping("/me")
    public ResponseEntity<ApiResponse<LoginResponse>> getCurrentUser(@RequestHeader("Authorization") String token) {
        try {
            if (token != null && token.startsWith("Bearer ")) {
                String jwtToken = token.substring(7);
                String username = jwtUtil.extractUsername(jwtToken);
                
                User user = userDetailsService.getUserByUsername(username);
                
                LoginResponse userInfo = new LoginResponse();
                userInfo.setUserId(user.getId());
                userInfo.setUsername(user.getUsername());
                userInfo.setRole(user.getRole().name());
                userInfo.setName(user.getName() + " " + user.getLastName());
                
                return ResponseEntity.ok(ApiResponse.success("Información del usuario", userInfo));
            }
            
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Token requerido"));
                
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al obtener información del usuario: " + e.getMessage()));
        }
    }

    /**
     * Método auxiliar para autenticar usuario
     */
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
