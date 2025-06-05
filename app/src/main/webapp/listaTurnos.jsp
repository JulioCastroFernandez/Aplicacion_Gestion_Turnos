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
        <form class="search" action="/app/busquedaForm" method="POST">
   <%
       String estadoSeleccionado = (String) request.getAttribute("estado");
   %>
   <select id="estado-turno" name="estado" class="select">
       <option value="" disabled <%= (estadoSeleccionado == null || estadoSeleccionado.isBlank()) ? "selected" : "" %>>Estado turno</option>
       <option value="en-espera" <%= "en-espera".equals(estadoSeleccionado) ? "selected" : "" %>>En espera</option>
       <option value="ya-atendido" <%= "ya-atendido".equals(estadoSeleccionado) ? "selected" : "" %>>Ya atendido</option>
   </select>
             <input type="date" id="fecha" name="fecha" value ="<%= request.getAttribute("fecha") != null ? request.getAttribute("fecha") : "" %>">
            <button type="submit">Buscar</button>
        </form>
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
             if (listado != null) {
                for (Turno turno: listado) { %>
                          <tr>
                            <td style="padding: 8px; border: 1px solid #ddd;"><%= turno.getIdentificadorProgresivo() %></td>
                            <td style="padding: 8px; border: 1px solid #ddd;"><%= turno.getFecha() %></td>
                            <td style="padding: 8px; border: 1px solid #ddd;"><%= turno.getEstado() %></td>
                            <td style="padding: 8px; border: 1px solid #ddd;"><%= turno.getCiudadano().getNombre()%></td>
                        </tr>
                <% }
                 } %>

       </tbody>
   </table>
</main>

</body>
</html>