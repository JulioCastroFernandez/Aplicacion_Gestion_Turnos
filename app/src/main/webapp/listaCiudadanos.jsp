<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de ciudadanos</title>
    <link rel="stylesheet" href="public/css/style.css">
</head>
<body>
 <%@include file ="partials/header.jsp" %>
    <!-- Menú de navegación -->
<main class="pagina-lista-ciudadanos">
  <h2 class="titulo" style="margin-left: 30px;">lista de ciudadanos</h2>

  <table style="width: 75%; border-collapse: collapse; margin-left: 100px;">
       <thead style="background-color: rgb(130, 135, 238); color: #fff;">
           <tr>
               <th style="padding: 10px; border: 1px solid #ddd;">DNI</th>
               <th style="padding: 10px; border: 1px solid #ddd;">Nombre</th>
               <th style="padding: 10px; border: 1px solid #ddd;">Apellido</th>
           </tr>
       </thead>

       <tbody>
           <tr>
             <td style="padding: 8px; border: 1px solid #ddd;">Ejemplo DNI</td>
             <td style="padding: 8px; border: 1px solid #ddd;">Ejemplo Nombre</td>
             <td style="padding: 8px; border: 1px solid #ddd;">Ejemplo Apellido</td>
           </tr>
       </tbody>
   </table>
</main>
</body>
</html>