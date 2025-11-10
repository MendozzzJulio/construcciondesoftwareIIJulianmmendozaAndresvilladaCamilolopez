package app.infrastructure.adapter.api.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para la respuesta de login
 */
public class LoginResponse {
    
    @JsonProperty("token")
    private String token;
    
    @JsonProperty("userId")
    private Long userId;
    
    @JsonProperty("username")
    private String username;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("role")
    private String role;
    
    @JsonProperty("tokenType")
    private String tokenType = "Bearer";
    
    @JsonProperty("expiresIn")
    private long expiresIn = 86400; // 24 horas en segundos
    
    // Constructors
    public LoginResponse() {}
    
    // Getters y setters
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getTokenType() {
        return tokenType;
    }
    
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
    
    public long getExpiresIn() {
        return expiresIn;
    }
    
    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
