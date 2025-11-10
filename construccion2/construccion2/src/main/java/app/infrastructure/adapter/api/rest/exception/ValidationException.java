package app.infrastructure.adapter.api.rest.exception;

/**
 * Excepción para errores de validación (400 Bad Request)
 * Se lanza cuando hay errores en los builders/validators
 */
public class ValidationException extends RuntimeException {
    
    public ValidationException(String message) {
        super(message);
    }
    
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
