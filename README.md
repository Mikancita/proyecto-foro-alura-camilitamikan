Proyecto Foro – API REST (Spring Boot)

API REST para gestionar tópicos de un foro académico. Permite crear, listar, actualizar e inactivar tópicos, con validación, autenticación JWT, migraciones con Flyway y documentación Swagger.

Autora: Camila Mikan
Correo: camilitamikan@hotmail.com

Repo: https://github.com/Mikancita/proyecto-foro-alura-camilitamikan

✨ Funcionalidades

CRUD de tópicos:

GET /topicos (paginado)

POST /topicos

PUT /topicos

DELETE /topicos/{id} (borrado lógico)

Validación con Bean Validation (@NotNull, @Valid, etc.).

Autenticación vía JWT (POST /login → token).

Manejo de estados con ENUM Status.

Migraciones de BD con Flyway.

Swagger/OpenAPI para explorar la API.

🚀 Tecnologías

Java 17, Spring Boot 3

Spring Web, Spring Data JPA/Hibernate

Spring Security + JWT (Auth0 java-jwt)

Flyway (migraciones)

MySQL

Maven

SpringDoc OpenAPI (Swagger UI)

Lombok

▶️ Cómo ejecutar localmente

Requisitos: Java 17, Maven, MySQL

Clonar repo

git clone https://github.com/Mikancita/proyecto-foro-alura-camilitamikan.git
cd proyecto-foro-alura-camilitamikan


Crear base de datos

CREATE DATABASE foro_alura CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


Configurar src/main/resources/application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/foro_alura
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true

# JWT
api.security.secret=${JWT_SECRET:secret-local}


Compilar y levantar

mvn clean spring-boot:run


Flyway ejecutará las migraciones al iniciar.

Documentación (Swagger)

http://localhost:8080/swagger-ui/index.html

🔐 Autenticación

Login: POST /login

Body ejemplo:

{ "login": "usuario", "clave": "password" }


Respuesta:

{ "token": "<jwt>" }


Para consumir endpoints protegidos, incluir:

Authorization: Bearer <jwt>

📦 Estructura (resumen)
src/
 ├─ main/
 │   ├─ java/com/topicos/api/
 │   │   ├─ controller
 │   │   ├─ domain
 │   │   └─ infra (security, exceptions, docs)
 │   └─ resources/
 │       ├─ application.properties
 │       └─ db/migration (Flyway)
 └─ test/

🧪 Ejemplos de uso

Crear tópico – POST /topicos

{
  "titulo": "Error con Hibernate",
  "mensaje": "No se persiste fechaCreacion",
  "fechaCreacion": "2025-08-06T14:00:00",
  "status": "NO_RESPONDIDO",
  "autor_id": 1,
  "curso_id": 2
}


Actualizar tópico – PUT /topicos

{
  "id": 5,
  "titulo": "Título actualizado",
  "mensaje": "Mensaje actualizado"
}


Eliminar (lógico) – DELETE /topicos/{id}
Cambia el estado interno (no borra físicamente).

📝 Notas técnicas

Entidad principal: Topico (relación con autor/curso).

Status se maneja como ENUM en Java y se persiste como VARCHAR.

Se usan DTOs (records) para requests/responses.

Errores y validaciones centralizados en capa infra.

📄 Licencia

Uso académico/educativo.

👩‍💻 Autoría

Camila Mikan
camilitamikan@hotmail.com
 • GitHub: @Mikancita
