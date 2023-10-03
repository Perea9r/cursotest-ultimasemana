# MICROSERVICIOS CRUD CURSOS

Este proyecto esta diseñado para permitir la creación, lectura, actualización y eliminación de cursos. Se divide en dos partes independientes que se comunican entre sí para obtener la lista de cursos existentes.

## Requisitos

- Java 17
- Spring Boot 3.1.4
- Spring Boot Web Starter
- H2 Database
- Spring Boot Test Starter
- Mockito Core 5.5.0

## Instalación

1. Clona el repositorio en tu máquina local.
2. Abre una terminal en la carpeta raíz del proyecto y ejecuta el siguiente comando para compilar el proyecto: `mvn clean install` esto generará la carpeta `target` con nuestro proyecto compilado en un archivo JAR.
3. Ejecutar el proyecto con el comando `run` de Spring Boot en cada paquete.
4. La aplicación ya debería estar disponible en [localhost:8080](http://localhost:8080) y [localhost:8081](http://localhost:8081)

## Uso

Mandar peticiones desde el puerto 8080 a través de postman.

- **GET /cursos**: Devuelve una lista de todos los cursos disponibles en la aplicación.
- **GET /curso/{id}**: Busca un curso por su ID y devuelve el curso correspondiente si existe.
- **POST /curso**: Crea un nuevo curso con la información proporcionada en el cuerpo de la solicitud.
- **PUT /curso/{id}/{duracion}**: Actualiza un curso existente con la información proporcionada en el cuerpo de la solicitud.
- **DELETE /curso/{id}**: Elimina un curso existente por su ID.
- **GET /curso/{min}/{max}**: Devuelve una lista de cursos que se encuentran dentro del rango de precios especificado.

## Licencia

MIT License Copyright (c)
