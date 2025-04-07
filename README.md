Sistema Educativo Distribuido con Microservicios

Tecnologías y Herramientas Utilizadas:
Spring Boot (v3.x)
Spring Cloud (Config, Eureka)
Spring Web
Spring Data JPA
MySQL
MySQL Workbench
Maven
Java 17
VS Code
Postman
Git + GitHub

Arquitectura General:
Se diseñó un sistema educativo distribuido basado en arquitectura de microservicios, que permite la gestión de usuarios (estudiantes y docentes), matrículas, y configuración centralizada. Los microservicios se comunican entre sí mediante descubrimiento de servicios a través de Eureka, y las propiedades están centralizadas en un Config Server.

Microservicios Implementados:
eureka-server
Microservicio de descubrimiento que actúa como registro central para todos los demás.
Puerto: 8761.
Panel accesible en: http://localhost:8761.
Configuración en application.properties deshabilita el autoregistro (register-with-eureka: false).

config-server:
Centraliza la configuración de todos los microservicios.
Puerto: 8888.
Soporta perfil native para leer archivos desde el sistema de archivos.
Se conecta a Eureka para ser descubierto por los demás servicios.
Se creó un repositorio local config-repo con archivos YAML para cada microservicio (usuarios-service.yml, matriculas-service.yml).

usuarios-service:
Gestiona información de estudiantes y docentes.
Puerto definido dinámicamente en usuarios-service.yml vía config-server.
Registro en Eureka como USUARIOS-SERVICE.
Incluye conexión con base de datos MySQL.
Usa Spring Data JPA para persistencia de entidades.

matriculas-service:
Encargado del manejo de matrículas estudiantiles.
Puerto definido mediante configuración remota.
Registro en Eureka como MATRICULAS-SERVICE.
También conectado a MySQL.

Configuración de Base de Datos:
Se utilizó MySQL Workbench para crear las bases de datos requeridas.
Se definieron propiedades como spring.datasource.url, username, password, y jpa.hibernate.ddl-auto en los archivos YAML gestionados por el config-server.
Se crearon entidades, repositorios y controladores para manipular datos desde cada microservicio.

Estructura General del Proyecto sistema-educativo/:
sistema-educativo-microservicios/
│
├── config-server/
│   └── application.yml, configuración central
│
├── eureka-server/
│   └── Registro de servicios
│
├── usuarios-servicio/
│   ├── Modelos
│   ├── Repositorios
│   ├── Controladores
│   └── application.yml (via config-server)
│
├── matriculas-servicio/
│   ├── Modelos
│   ├── Repositorios
│   ├── Controladores
│   └── application.yml (via config-server)

Integraciones Clave
Spring Cloud Config: permite que todos los microservicios carguen su configuración desde un solo punto central.
Eureka Server: permite registrar y descubrir microservicios dinámicamente.
Base de Datos MySQL: cada servicio accede a su propia base de datos configurada a través de su application.yml.
Conexión probada desde Workbench y validada mediante logs de inicialización.
PA/Hibernate configurado para persistencia de datos, con Hikari como pool de conexiones.

Pruebas
Se ejecutaron pruebas unitarias mínimas para validar la correcta carga del contexto de aplicación.
Pruebas exitosas en usuarios-service, verificando su conexión con Eureka, Config Server y MySQL.
Todos los microservicios se levantan correctamente y se registran en Eureka:
Application           Status
-------------------   ------------------------
CONFIG-SERVER         UP (1) - localhost:8888
USUARIOS-SERVICE      UP (1) - puerto dinámico
MATRICULAS-SERVICE    UP (1) - puerto dinámico