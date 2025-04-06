# Sistema Educativo Distribuido - Microservicios

Este proyecto es una implementación de un sistema educativo basado en una arquitectura de microservicios utilizando Spring Boot y Spring Cloud.

## Microservicios del sistema

- **usuarios-servicio**: Gestión de estudiantes y docentes.
- **asignaturas-servicio**: CRUD de asignaturas.
- **matriculas-servicio**: Registro de estudiantes en asignaturas.
- **config-server** : Este va hacer el servidor central de configuración
- **Eureka-server**: Este sera un servicio de descubrimiento Eureka

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

# Desarollo

1. Se realiza la creación de una carpeta local: sistema-educativo-microservicios-harold-valencia-juan-rodriguez
   Aquí encontraremos el contenedor del proyecto distribuido de microservicios
2. Creamos las siguientes carpetas dentro de la carpeta sistema-educativo-microservicios-harold-valencia-juan-rodriguez
   usuarios-servicio
   asignaturas-servicio
   matriculas-servicio
   config-server 
   eureka-server 
3. Realizamos la creación del README.md con la descripción general del sistema, listando
   Los microservicios que la componen
   Las tecnologías utilizadas (Java, Spring Boot, Sprinh Cloud, JWT, Docker, Git)
   El enfoque de la distrubución que se utilizara para nuestra arquitectura
4. Inicialización del repositorio local de Git con el comando: git init
   Se añadio el README.md al área de staging con el comando: git add README.md
   Se realiza el primer commit con el comando y nombre: git commit -m "Estructura inicial del proyecto y carpetas de microservicios creadas"
   Se sube el proyecto a GitHub, se crea un repositorio remoto en Git: https://github.com/RodriguezF-JuanSebastian/sistema-educativo-microservicios
   Se realiza la vinculación del repositorio local con el remoto y se subio el primer commit con los comandos:
   git remote add origin https://github.com/RodriguezF-JuanSebastian/sistema-educativo-microservicios.git
   git branch -M main
   git push -u origin main
