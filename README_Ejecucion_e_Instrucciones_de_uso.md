---- Cómo ejecutar la WebApp "Gestión de turnos" ----

Requisitos e instrucciones para poder ejecutar la aplicación correctamente en tu entorno local:

**** 1. Requisitos ****

- Java JDK 17 o superior
- IntelliJ IDEA
- XAMPP con MySQL activo
- Servidor local Tomcat
- Navegador web
- *Opcional: descargar "MySQL Workbench" para trabajar con la BD sin necesidad del navegador.

**** 2. Configurar la base de datos ****

1. Abre XAMPP y asegúrate de que MySQL esté ejecutándose.
2. Entra a [phpMyAdmin](http://localhost/phpmyadmin) o MySQL Workbench.
3. Crea una base de datos llamada:  
   
	"gestionturnos_bd"	

4. No es necesario crear tablas, ya que se generarán automáticamente mediante JPA al iniciar la aplicación.

**** 3. Configurar IntelliJ IDEA ****
 
1. Abre IntelliJ y selecciona "Open".
2. Busca el proyecto "Aplicacion_Gestion_Turnos", abre la carpeta app, selecciona y ejecuta el archivo "pom.xml".
3. Selecciona "Open as a Project".


**** 4. Ejecutar el servidor ****

1. Usa Tomcat dentro de IntelliJ.
2. Compila y despliega el proyecto.
3. Accede desde el navegador a:

http://localhost:8080/



---- Cómo utilizar la WebApp "Gestión de turnos" ----

Una vez accedas a la WebApp te encontraras con la pantalla inicio y las siguientes opciones:

1. Inicio. 
2. Turno. 
3. Ciudadano.

Ahora vamos a explicar cada opción por separado:

**** 1. Inicio ****

Al hacer click, nos devuelve a la pantalla de inicio de la WebApp.

**** 2. Ciudadano ****

Al pasar el ratón por encima desplegara las dos opciones disponibles.

a. Nuevo ciudadano: Al hacer click en esta opción accederemos al formulario para añadir a un nuevo ciudadano a la BD.

b. Lista de ciudadanos: Al hacer click en esta opción accederemos a la lista de ciudadanos que hay en la BD.

**** 3. Turno ****

Al pasar el ratón por encima desplegara las dos opciones disponibles.

a. Nuevo turno: Al hacer click en esta opción accederemos al formulario para crear un nuevo turno en la BD.

b. Lista de turnos: Al hacer click en esta opción accederemos a la lista de turnos que hay en la BD.




