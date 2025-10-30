📚 Gestión de Biblioteca

Sistema de gestión de biblioteca desarrollado en Java 17 con Spring Boot y Gradle.
Permite administrar libros, usuarios y préstamos de manera sencilla mediante una API REST.
________________________________________
✨ Características principales

•	✅ Gestión de Libros (crear, listar, actualizar, eliminar).

•	✅ Gestión de Usuarios (alta, consulta, modificación, baja).

•	✅ Registro y control de Préstamos de libros.

•	✅ API REST organizada en capas (Controller → Service → Repository).

•	✅ Persistencia con Spring Data JPA. (Se usa esta herramienta por su fácil operación y actualización) 

•	✅ Base de datos configurable (H2 por defecto, soporta PostgreSQL/MySQL).

•	✅ Pruebas unitarias básicas incluidas.
________________________________________
📂 Estructura del proyecto
gestion-biblioteca/
 ├── build.gradle              
 ├── settings.gradle
 ├── src/
 │   ├── main/java/com/biblioteca/gestion_biblioteca/
 │   │   ├── GestionBibliotecaApplication.java   
 │   │   ├── controller/   
 │   │   ├── service/      
 │   │   ├── repository/   
 │   │   └── model/        
 │   └── test/java/...     
 └── ...
________________________________________
⚙️ Requisitos previos
•	Java 17+
•	Gradle 8+ (opcional, se incluye gradlew)
•	Una base de datos (H2 en memoria por defecto, también puedes usar MySQL/PostgreSQL).
________________________________________
🚀 Instalación y ejecución

1. Clonar el repositorio
git clone https://github.com/aconeop/gestion-biblioteca.git
cd gestion-biblioteca/gestion-biblioteca
________________________________________
2. Ejecutar con Gradle (terminal)
   
./gradlew clean bootRun --args="--spring.profiles.active=dev"
La aplicación quedará disponible en:
👉 http://localhost:8085/swagger-ui/index.html?
________________________________________
3. Ejecutar con IntelliJ IDEA
   
1.	Abre IntelliJ IDEA
2.	Ve a File → Open… y selecciona la carpeta gestion-biblioteca
3.	IntelliJ detectará automáticamente el proyecto Gradle y descargará las dependencias.
o	Si no lo hace, asegúrate de que en la barra lateral derecha esté activado el panel de Gradle y haz clic en Reload All Gradle Projects.
4.	En el explorador de archivos, abre la clase:
5.	src/main/java/com/biblioteca/gestion_biblioteca/GestionBibliotecaApplication.java
6.	Haz clic derecho sobre el archivo y selecciona Run 'GestionBibliotecaApplication.main()'
7.	IntelliJ compilará y levantará la aplicación.
La aplicación quedará corriendo en:
👉 http://localhost:8085/swagger-ui/index.html?
________________________________________

🛠️ Endpoints principales

📖 Libros

•	GET /libros → Listar libros

•	GET /libros/{id} → Obtener libro por ID

•	POST /libros → Crear libro

•	PUT /libros/{id} → Actualizar libro

•	DELETE /libros/{id} → Eliminar libro

👤 Usuarios

•	GET /usuarios → Listar usuarios

•	POST /usuarios → Crear usuario

•	PUT /usuarios/{id} → Actualizar usuario

•	DELETE /usuarios/{id} → Eliminar usuario

📑 Préstamos

•	GET /prestamos → Listar préstamos

•	POST /prestamos → Registrar préstamo

•	PUT /prestamos/{id} → Actualizar préstamo

•	DELETE /prestamos/{id} → Eliminar préstamo
________________________________________
🗄️ Configuración de base de datos

Por defecto usa H2 en memoria.

Se puede cambiar en src/main/resources/application.properties:

spring.datasource.url=jdbc:h2:mem:biblioteca

spring.datasource.driverClassName=org.h2.Driver

spring.datasource.username=sa

spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update

Ejemplo para MySQL:

spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca

spring.datasource.username=root

spring.datasource.password=tu_clave

spring.jpa.hibernate.ddl-auto=update
________________________________________
📌 Roadmap / Mejoras futuras

•	🔹 Autenticación y autorización con Spring Security.

•	🔹 Validaciones más robustas con Bean Validation.

•	🔹 Documentación automática con Swagger/OpenAPI.

•	🔹 Frontend en Angular/React para consumir la API.

Nota: Este proyecto se encuentra en fase de construcción y será modificado durante el curso
________________________________________
🤝 Contribuciones
1.	Haz un fork del repositorio
2.	Crea una rama: git checkout -b feature/nueva-funcionalidad
3.	Realiza tus cambios y haz commit
4.	Envía un Pull Request
