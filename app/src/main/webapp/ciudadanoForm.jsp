<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Nuevo ciudadano</title>
    <link rel="stylesheet" href="public/css/style.css">
</head>
<body>
 <%@include file ="partials/header.jsp" %>
    <!-- Menú de navegación -->

 <main>
    <h2 class="titulo" style="margin-left: 30px;">Nuevo ciudadano</h2>

    <form action="ciudadanoForm" method="post" class="form_app">
      <label for="dni">DNI:</label>
      <input type="dni" id="dni" placeholder="Tu dni" name="dni" required>

      <label for="nombre">Nombre:</label>
      <input type="text" id="nombre" name="nombre" placeholder="Tu nombre" required>
      <label for="apellido">Apellido:</label>
      <input type="text" id="apellido" name="apellido" placeholder="Tu apellido" required>

      <button type="submit" class="boton-nuevo">Nuevo</button>
    </form>
</main>

</body>
</html>