<!DOCTYPE html>
<%@ page import = "java.util.List, entities.Turno" %>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de turnos</title>
    <link rel="stylesheet" href="public/css/style.css">
</head>
<body>
 <%@include file ="partials/header.jsp" %>
<main class="pagina-lista-turnos">
  <h2 class="titulo" style="margin-left: 30px;">lista de turnos</h2>

  <table style="width: 75%; border-collapse: collapse; margin-left: 100px;">
       <thead style="background-color: rgb(130, 135, 238); color: #fff;">
           <tr>
               <th style="padding: 10px; border: 1px solid #ddd;">Identificador progresivo</th>
               <th style="padding: 10px; border: 1px solid #ddd;">fecha</th>
               <th style="padding: 10px; border: 1px solid #ddd;">estado</th>
               <th style="padding: 10px; border: 1px solid #ddd;">ciudadano</th>
           </tr>
       </thead>

       <tbody>

         <% List<Turno> listado = (List<Turno>) request.getAttribute("listado");
                for (Turno turno: listado) { %>
                          <tr>
                            <td style="padding: 8px; border: 1px solid #ddd;"><%= turno.getidentificadorProgresivo() %></td>
                            <td style="padding: 8px; border: 1px solid #ddd;"><%= turno.getFecha() %></td>
                            <td style="padding: 8px; border: 1px solid #ddd;"><%= turno.getEstado() %></td>
                            <td style="padding: 8px; border: 1px solid #ddd;"><%= turno.getCiudadano().getNombre()%></td>
                        </tr>
                <% } %>

       </tbody>
   </table>
</main>

</body>
</html>