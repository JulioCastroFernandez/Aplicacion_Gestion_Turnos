package servlets;


import controllers.CiudadanoController;
import controllers.TurnoController;
import entities.Ciudadano;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(urlPatterns = "/turnoForm")
public class turnosFormServlet extends HttpServlet {

    private final TurnoController turnoController = new TurnoController();
    private final CiudadanoController ciudadanoController = new CiudadanoController();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Ciudadano>  lista = ciudadanoController.listarCiudadanos();

        //envio de datos a la vista
         req.setAttribute("listado", lista);
        //devolvemos a la vista
        req.getRequestDispatcher("turnoForm.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //se recogen los datos
        String estado = request.getParameter("tipo-turno");
        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
        Long id = Long.valueOf(request.getParameter("ciudadano"));
        //creacion objecto
        turnoController.crearTurno(estado,fecha,id);

        response.sendRedirect("/app/listaTurnos");

    }
}
