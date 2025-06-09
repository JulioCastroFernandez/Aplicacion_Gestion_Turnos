<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Inicio</title>
    <link rel="stylesheet" href="public/css/style.css">
</head>
<body>
    <%@ include file="partials/header.jsp" %>

    <main class="contenido" style="margin-left:40px;">
        <h1>Cómo ejecutar la WebApp "Gestión de turnos"</h1>

        <h2>Requisitos e instrucciones para poder ejecutar la aplicación correctamente en tu entorno local:</h2>

        <ol>
            <li>
                <strong>Requisitos</strong>
                <p>
                    Java JDK 17 o superior<br>
                    IntelliJ IDEA<br>
                    XAMPP con MySQL activo<br>
                    Servidor local Tomcat<br>
                    Navegador web<br>
                    <em>*Opcional:</em> descargar "MySQL Workbench" para trabajar con la BD sin necesidad del navegador
                </p>
            </li>
            <li>
                <strong>Configurar la base de datos</strong>
                <p>
                    Abre XAMPP y asegúrate de que MySQL esté ejecutándose.<br>
                    Entra a phpMyAdmin o MySQL Workbench.<br>
                    Crea una base de datos llamada: <strong>gestionturnos_bd</strong><br>
                    No es necesario crear tablas, ya que se generarán automáticamente mediante JPA al iniciar la aplicación.
                </p>
            </li>
            <li>
                <strong>Configurar IntelliJ IDEA</strong>
                <p>
                    Abre IntelliJ y selecciona "Open".<br>
                    Busca el proyecto <strong>Aplicacion_Gestion_Turnos</strong>, abre la carpeta <strong>app</strong>, selecciona y abre el archivo <strong>pom.xml</strong>.<br>
                    Selecciona "Open as a Project".
                </p>
            </li>
            <li>
                <strong>Ejecutar el servidor</strong>
                <p>
                    Usa Tomcat dentro de IntelliJ.<br>
                    Compila y despliega el proyecto.<br>
                    Accede desde el navegador a: <a href="http://localhost:8080/" target="_blank">http://localhost:8080/</a>
                </p>
            </li>
        </ol>

        <h2>Ahora vamos a explicar cada opción por separado:</h2>
        <p>Una vez accedas a la WebApp te encontrarás con la pantalla de inicio y las siguientes opciones:</p>

        <ol>
            <li>
                <strong>Inicio</strong>
                <p>Al hacer clic, nos devuelve a la pantalla de inicio de la WebApp.</p>
            </li>
            <li>
                <strong>Ciudadano</strong>
                <p>Al pasar el ratón por encima, se desplegarán dos opciones disponibles:</p>
                <ol type="A">
                    <li><strong>Nuevo ciudadano:</strong> Accederás al formulario para añadir un nuevo ciudadano a la BD.</li>
                    <li><strong>Lista de ciudadanos:</strong> Accederás a la lista de ciudadanos registrados en la BD.</li>
                </ol>
            </li><br>
            <li>
                <strong>Turno</strong>
                <p>También ofrece dos opciones:</p>
                <ol type="A">
                    <li><strong>Nuevo turno:</strong> Accederás al formulario para asignar un nuevo turno.</li>
                    <li><strong>Lista de turnos:</strong> Accederás a la lista de turnos registrados.</li>
                </ol>
            </li>
        </ol>
    </main>
</body>
</html>
