# Sistema Educativo Distribuido - Microservicios

Este proyecto es una implementación de un sistema educativo basado en una arquitectura de microservicios utilizando Spring Boot y Spring Cloud.

## Microservicios del sistema

- **usuarios-servicio**: Gestión de estudiantes y docentes.
- **asignaturas-servicio**: CRUD de asignaturas.
- **matriculas-servicio**: Registro de estudiantes en asignaturas.

## Tecnologías utilizadas

- Java + Spring Boot
- Spring Cloud (Eureka, Config Server, Feign)
- JWT para seguridad
- Docker para despliegue
- GitHub para control de versiones

## Enfoque distribuido

Cada microservicio cuenta con su propia base de datos, configuración independiente y comunicación vía REST utilizando FeignClient. El objetivo es lograr un sistema escalable, seguro y
mantenible

---
