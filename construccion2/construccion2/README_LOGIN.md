# Sistema de Autenticación con Spring Security y JWT

## Descripción
Se ha integrado completamente Spring Security con JWT para el sistema médico. Ahora el sistema maneja autenticación real con tokens JWT.

## Endpoints de Autenticación

### 1. Login
**POST** `/api/auth/login`

**Request Body:**
```json
{
  "username": "admin",
  "password": "password123"
}
```

**Response:**
```json
{
  "success": true,
  "message": "Login exitoso",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiJ9...",
    "userId": 1,
    "username": "admin",
    "name": "Juan Pérez",
    "role": "ADMINISTRATIVE",
    "tokenType": "Bearer",
    "expiresIn": 86400
  },
  "timestamp": 1699564800000
}
```

### 2. Validar Token
**POST** `/api/auth/validate`

**Headers:**
```
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

### 3. Información del Usuario Actual
**GET** `/api/auth/me`

**Headers:**
```
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

## Uso de la API

### 1. Hacer Login
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "admin",
    "password": "password123"
  }'
```

### 2. Usar Token en Peticiones
```bash
curl -X GET http://localhost:8080/api/administrative/patients/12345678 \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9..."
```

## Roles y Permisos

- **HR**: `/api/hr/**` - Gestión de empleados
- **ADMINISTRATIVE**: `/api/administrative/**` - Gestión de pacientes y facturación
- **DOCTOR**: `/api/doctor/**` - Registros médicos y órdenes
- **NURSE**: `/api/nurse/**` - Visitas y búsquedas

## Configuración

### application.yml
```yaml
jwt:
  secret: mySecretKeyForMedicalBillingSystemThatShouldBeVeryLongAndSecure123456789
  expiration: 86400 # 24 horas
```

## Cambios Realizados

1. **Spring Security Configuration**: Configuración completa con JWT
2. **JWT Utilities**: Generación y validación de tokens
3. **Custom UserDetailsService**: Carga usuarios desde la base de datos
4. **JWT Request Filter**: Procesa tokens en cada petición
5. **AuthController**: Endpoints de login y validación
6. **AuthenticationService**: Integrado con Spring Security
7. **Controladores Simplificados**: Ya no requieren headers manuales

## Flujo de Autenticación

1. Usuario hace login con username/password
2. Sistema valida credenciales
3. Se genera token JWT con información del usuario
4. Cliente incluye token en header `Authorization: Bearer <token>`
5. JWT Filter procesa el token y establece el usuario en el contexto
6. AuthenticationService obtiene el usuario del contexto
7. Controladores usan el usuario autenticado automáticamente

## Seguridad

- Tokens JWT firmados con clave secreta
- Expiración configurable (24 horas por defecto)
- Validación de roles por endpoint
- Contexto de seguridad manejado por Spring Security
- Passwords encriptados con BCrypt
