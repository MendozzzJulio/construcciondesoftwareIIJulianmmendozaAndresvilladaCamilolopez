package app.infrastructure.adapter.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import app.domain.entities.User;
import app.domain.ports.UserPort;

import java.util.Collections;

/**
 * Servicio personalizado para cargar detalles del usuario desde la base de datos
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserPort userPort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            // Crear usuario para búsqueda
            User searchUser = new User();
            searchUser.setUsername(username);
            
            // Buscar usuario por username
            User user = userPort.findByUsername(searchUser);
            
            if (user == null) {
                throw new UsernameNotFoundException("Usuario no encontrado: " + username);
            }

            // Crear UserDetails con la información del usuario
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().name())))
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .disabled(false)
                    .build();
                    
        } catch (Exception e) {
            throw new UsernameNotFoundException("Error al cargar usuario: " + username, e);
        }
    }

    /**
     * Método auxiliar para obtener el usuario completo por username
     */
    public User getUserByUsername(String username) throws Exception {
        User searchUser = new User();
        searchUser.setUsername(username);
        return userPort.findByUsername(searchUser);
    }
}
