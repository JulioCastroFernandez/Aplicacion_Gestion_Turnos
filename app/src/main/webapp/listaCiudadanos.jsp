<!DOCTYPE html>
<%@ page import="java.util.List, entities.Ciudadano" %>
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
  <h2 class="titulo" style="margin-left: 30px;">Lista de ciudadanos</h2>

  <table style="width: 75%; border-collapse: collapse; margin-left: 100px;">
       <thead style="background-color: rgb(130, 135, 238); color: #fff;">
           <tr>
               <th style="padding: 10px; border: 1px solid #ddd;">DNI</th>
               <th style="padding: 10px; border: 1px solid #ddd;">Nombre</th>
               <th style="padding: 10px; border: 1px solid #ddd;">Apellido</th>
           </tr>
       </thead>

       <tbody>

           <% List<Ciudadano> listado = (List<Ciudadano>) request.getAttribute("listado");
            for (Ciudadano persona: listado) { %>
                  <tr>
                     <td style="padding: 8px; border: 1px solid #ddd;"><%= persona.getDni() %></td>
                     <td style="padding: 8px; border: 1px solid #ddd;"><%= persona.getNombre() %></td>
                     <td style="padding: 8px; border: 1px solid #ddd;"><%= persona.getApellido() %></td>
                 </tr>
           <% } %>

       </tbody>
   </table>
</main>
</body>
</html>