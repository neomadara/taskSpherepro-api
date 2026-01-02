# TaskSphere API

API REST para gestión de tareas construida con Spring Boot.

## Tecnologías

- Java 17+
- Spring Boot 3.x
- Spring Security con JWT
- PostgreSQL
- Flyway (Migraciones de BD)
- Maven

## Requisitos Previos

- JDK 17 o superior
- Maven 3.6+
- PostgreSQL (o Docker para ejecutar con Docker Compose)

## Configuración Inicial

### 1. Clonar el repositorio

```bash
git clone <tu-repositorio>
cd tasksphere-api
```

### 2. Configurar Base de Datos

Puedes usar Docker Compose para levantar PostgreSQL:

```bash
docker-compose up -d
```

O configurar manualmente PostgreSQL y actualizar `src/main/resources/application.properties`.

### 3. Generar Claves RSA para JWT

**Importante:** Las claves RSA son necesarias para firmar y verificar tokens JWT. Estas claves NO deben ser subidas a control de versiones.

Ejecuta los siguientes comandos en la raíz del proyecto:

```bash
# Crear directorio para las claves
mkdir -p src/main/resources/certs

# Generar clave privada RSA
openssl genrsa -out src/main/resources/certs/private.pem 2048

# Extraer clave pública
openssl rsa -in src/main/resources/certs/private.pem -pubout -out src/main/resources/certs/public.pem
```

### 4. Configurar variables de entorno (opcional)

Puedes configurar variables de entorno adicionales según sea necesario en `application.properties`.

### 5. Compilar y ejecutar

```bash
# Compilar el proyecto
mvn clean install

# Ejecutar la aplicación
mvn spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`

## Endpoints de la API

### Autenticación

- `POST /api/users/register` - Registrar nuevo usuario
- `POST /api/users/login` - Iniciar sesión y obtener token JWT

### Usuarios (requiere autenticación)

- `GET /api/users` - Obtener información del usuario actual

## Seguridad

### Claves RSA

Las claves RSA privadas son sensibles y **NUNCA** deben ser compartidas o subidas a repositorios públicos. El archivo `.gitignore` está configurado para excluir estos archivos automáticamente.

En producción, considera usar:
- Variables de entorno
- Servicios de gestión de secretos (AWS Secrets Manager, Azure Key Vault, etc.)
- Sistemas de configuración centralizada

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/zero/tasksphere/
│   │       ├── config/          # Configuración de seguridad y propiedades
│   │       ├── controller/      # Controladores REST
│   │       ├── dto/             # Objetos de transferencia de datos
│   │       ├── entity/          # Entidades JPA
│   │       ├── repository/      # Repositorios de datos
│   │       └── service/         # Lógica de negocio
│   └── resources/
│       ├── application.properties
│       ├── certs/               # Claves RSA (no versionadas)
│       └── db/migration/        # Scripts Flyway
└── test/
```

## Contribuir

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit tus cambios (`git commit -am 'Agregar nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Crea un Pull Request

## Licencia

[Especifica tu licencia aquí]

