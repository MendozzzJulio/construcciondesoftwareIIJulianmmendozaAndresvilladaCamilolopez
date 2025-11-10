package app.adapter.in.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.domain.entities.User;
import app.domain.services.AuthenticationService;

/**
 * Helper class para manejar la autenticación en los clientes
 * Esta clase debe ser usada por los controladores/clientes para establecer el usuario actual
 */
@Component
public class AuthenticationHelper {
    
    @Autowired
    private AuthenticationService authenticationService;
    
    /**
     * Establece el usuario actual en el contexto de autenticación
     * Este método debe ser llamado al inicio de cada operación que requiera autenticación
     * 
     * @param user Usuario que está realizando la operación
     */
    public void setCurrentUser(User user) {
        authenticationService.setCurrentUser(user);
    }
    
    /**
     * Limpia el contexto de autenticación
     * Este método debe ser llamado al finalizar cada operación
     */
    public void clearContext() {
        authenticationService.clearCurrentUser();
    }
    
    /**
     * Obtiene el usuario actual del contexto
     * @return Usuario actual o null si no hay usuario autenticado
     */
    public User getCurrentUser() {
        return authenticationService.getCurrentUser();
    }
    
    /**
     * Ejemplo de uso en un método de cliente:
     * 
     * public void createBilling(User currentUser, Billing billing) {
     *     try {
     *         authHelper.setCurrentUser(currentUser);
     *         administrativeUseCase.createBilling(billing);
     *     } finally {
     *         authHelper.clearContext();
     *     }
     * }
     */
}
