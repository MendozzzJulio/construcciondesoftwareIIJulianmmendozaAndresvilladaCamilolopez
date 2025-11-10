package app.infrastructure.adapter.api.rest.exception;

/**
 * Excepción para recursos no encontrados (404 Not Found)
 */
public class NotFoundException extends RuntimeException {
    
    public NotFoundException(String message) {
        super(message);
    }
    
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
