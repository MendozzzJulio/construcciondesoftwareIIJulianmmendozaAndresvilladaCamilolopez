package app.domain.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import app.domain.entities.User;
import app.domain.entities.enums.Role;

/**
 * Servicio para manejar la autenticación integrado con Spring Security
 * Maneja el contexto del usuario actual y validaciones de roles
 */
@Service
public class AuthenticationService {
    
    // ThreadLocal para mantener el usuario actual en el contexto
    private ThreadLocal<User> currentUserContext = new ThreadLocal<>();
    
    /**
     * Establece el usuario actual en el contexto
     * Este método sería llamado por el sistema de autenticación
     */
    public void setCurrentUser(User user) {
        currentUserContext.set(user);
    }
    
    /**
     * Obtiene el usuario actualmente autenticado
     * Primero intenta obtenerlo del ThreadLocal, si no está disponible,
     * intenta obtenerlo del contexto de Spring Security
     * @return Usuario actual o null si no hay usuario autenticado
     */
    public User getCurrentUser() {
        User user = currentUserContext.get();
        
        if (user == null) {
            // Intentar obtener del contexto de Spring Security
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated() && 
                !authentication.getPrincipal().equals("anonymousUser")) {
                // En este caso, el usuario debería estar establecido por el JwtRequestFilter
                // Si no está, significa que hay un problema en la configuración
                throw new RuntimeException("Usuario no establecido en el contexto de autenticación");
            }
        }
        
        return user;
    }
    
    /**
     * Valida que el usuario actual tenga el rol especificado
     * @param requiredRole Rol requerido
     * @throws Exception Si no hay usuario autenticado o no tiene el rol requerido
     */
    public void validateUserRole(Role requiredRole) throws Exception {
        User currentUser = getCurrentUser();
        
        if (currentUser == null) {
            throw new Exception("No hay usuario autenticado en el sistema");
        }
        
        if (currentUser.getRole() != requiredRole) {
            throw new Exception("El usuario no tiene permisos para realizar esta operación. Se requiere rol: " + requiredRole);
        }
    }
    
    /**
     * Valida que el usuario actual tenga uno de los roles especificados
     * @param allowedRoles Roles permitidos
     * @throws Exception Si no hay usuario autenticado o no tiene ninguno de los roles permitidos
     */
    public void validateUserRoles(Role... allowedRoles) throws Exception {
        User currentUser = getCurrentUser();
        
        if (currentUser == null) {
            throw new Exception("No hay usuario autenticado en el sistema");
        }
        
        for (Role role : allowedRoles) {
            if (currentUser.getRole() == role) {
                return; // Usuario tiene uno de los roles permitidos
            }
        }
        
        throw new Exception("El usuario no tiene permisos para realizar esta operación");
    }
    
    /**
     * Limpia el contexto del usuario actual
     * Útil para testing o al finalizar una sesión
     */
    public void clearCurrentUser() {
        currentUserContext.remove();
    }
    
    /**
     * Verifica si hay un usuario autenticado actualmente
     * @return true si hay un usuario autenticado, false en caso contrario
     */
    public boolean isAuthenticated() {
        User currentUser = getCurrentUser();
        return currentUser != null;
    }
    
    /**
     * Obtiene el username del usuario actual
     * @return Username del usuario actual o null si no está autenticado
     */
    public String getCurrentUsername() {
        User currentUser = getCurrentUser();
        return currentUser != null ? currentUser.getUsername() : null;
    }
    
    /**
     * Obtiene el rol del usuario actual
     * @return Rol del usuario actual o null si no está autenticado
     */
    public Role getCurrentUserRole() {
        User currentUser = getCurrentUser();
        return currentUser != null ? currentUser.getRole() : null;
    }
}
