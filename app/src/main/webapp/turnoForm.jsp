<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Inicio</title>
    <link rel="stylesheet" href="public/css/style.css">
</head>
<body>
 <%@include file ="partials/header.jsp" %>
    <!-- Menú de navegación -->
   <h2 class="titulo" style="margin-left: 30px;">Nuevo turno</h2>


<form action="#" method="post" class="form_app">
  <label for="fecha">Fecha:</label>
  <input type="date" id="fecha" name="fecha" required>

  <label for="nombre">Ciudadano:</label>
  <input type="text" id="nombre" name="nombre" placeholder="Tu nombre completo" required>

   <label for="estado">Estado de turno:</label>
  <select id="estado-turno" name="tipo-turno" required class="select-turno">
    <option value="" disabled selected>Estado turno</option>
    <option value="mañana">En espera</option>
    <option value="tarde">Ya atendido</option>
  </select>

  <button type="submit" class="boton-nuevo">Nuevo</button>
</form>

</main>

</body>
</html>