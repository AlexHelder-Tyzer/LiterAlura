# LiteAlura (Proyecto Backend)

## Descripción

Este es un proyecto de LiterAlura con consumo de API de la plataforma [Gutendex](https://gutendex.com/books/) y utilizando el sistema agil de desarrollo en Trello.
En este emocionante desafío de programación dado por el [Programa ONE](https://www.oracle.com/pe/education/oracle-next-education/) junto a [Alura Latam](https://www.aluracursos.com/).
Se desarrolla un Catálogo de Libros que ofrece una interacción textual (vía consola) con los usuarios, proporcionando al menos 7 opciones de interacción. Los libros se buscarán a través de una API [Gutendex](https://gutendex.com/).
La información sobre la API y las opciones de interacción con el usuario se detallará a continuacion:

Los pasos para completar este desafío se detallarán a continuación y estarán disponibles en la sección adyacente:

- Configuración del Ambiente Java;
- Creación del Proyecto;
- Consumo de la API;
- Análisis de la Respuesta JSON;
- Inserción y consulta en la base de datos;
- Exibición de resultados a los usuarios;

## Ejecucion 🚀
a. Menu de opciones, aceptable a todos.

![image](https://github.com/AlexHelder-Tyzer/LiterAlura/assets/72510437/bd1b2969-8299-4e48-8f41-6b8b11acd0db)

Nota: la opcion listar Libros por idioma tiene un submenu:

![image](https://github.com/AlexHelder-Tyzer/LiterAlura/assets/72510437/d5406ea3-421a-4b05-ab4b-43aa3407a9a1)


PRUEBA DE EJECUCION (Listar libros registrados)

![image](https://github.com/AlexHelder-Tyzer/LiterAlura/assets/72510437/4a2150f6-7e29-4e84-9fc6-bceff9d8b0f8)

## Construido Con 🛠️

Tecnologias con las que fue trabajado el proyecto:

- [Gutendex-API](https://gutendex.com/books/) - Consumo de API y su [documentacion](https://gutendex.com/)
- [Git](https://git-scm.com/) - Control de versions
- [Trello](https://trello.com/) - Gestion de tareas
- [Postman](https://www.postman.com/) - Pruebas API
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - Documentacion Spring Data JPA
- [JPA](https://docs.spring.io/spring-data/jpa/reference/jpa.html) - Documentacion JPA

**Configuración del entorno de desarrollo Java para nuestro desafío de construcción del LiterAlura en un proyecto Spring.**

Asegúrate de contar con los siguientes programas, archivos y versiones:

- Java JDK: versión: 22 en adelante - [Download the Latest Java LTS Free](https://www.oracle.com/br/java/technologies/downloads/)
- Maven: versión 4 en adelante
- Spring: versión 3.3.1 - [Generar Proyecto](https://start.spring.io/)
- Postgres: versión 16 en adelante - [PostgreSQL: Downloads](https://www.postgresql.org/download/)
- IDE (Entorno de desenvolvimento integrado) IntelliJ IDEA- opcional - [Descargar IntelliJ IDEA: el IDE líder para Java y Kotlin](https://www.jetbrains.com/es-es/idea/download/?section=windows)

Configuración al crear el proyecto en Spring Initializr:

- Java (versión 22 en adelante)
- Maven (Initializr utiliza la versión 4)
- Spring Boot (versión 3.3.1)
- Proyecto en JAR
  
Dependencias para agregar al crear el proyecto en Spring Initializr:

- Spring Data JPA
- Postgres Driver

Dependencia adicional a agregar:
- Jackson Databind (version 2.17.1) - [jackson](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.17.1)

## Roadmap

Este proyecto tendra mejoras a futuro con las especificaciones mencionadas:

* **Buscar autor por nombre**: Si has echado un vistazo al sitio de la API es posible realizar la búsqueda de libro o autor con la consulta hecha con search? - sin embargo, en este caso te desafiamos a realizar la consulta por nombre de autor en la base de datos creada para nuestro proyecto.
* **Listar autores con otras consultas**: Aquí dejamos como sugerencia implementar otras consultas con los atributos de año de nacimiento y fallecimiento de los autores. Siéntete libre de explorar e implementar estas características adicionales.

## Versionado 📌

Usamos [Git](https://git-scm.com) para el control de versiones.
## Autores ✒️

- **Alex Helder Huancara CC.** - _Trabajo inicial_ - [Alex Helder Huancara CC.](https://github.com/AlexHelder-Tyzer)

## Licencia 📄

Este proyecto está libre.
