package servlets;
import controllers.TurnoController;
import entities.Turno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@WebServlet(urlPatterns = "/listaTurnos")
public class turnosServlet extends HttpServlet {

    private final TurnoController turnoController = new TurnoController();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fechaBuscadaString = req.getParameter("fecha");
        String estado = req.getParameter("estado");

        List<Turno> filtrados = turnoController.listarTodosTurnos();


        req.setAttribute("listado", filtrados);
        //devolvemos la vista
        req.getRequestDispatcher("listaTurnos.jsp").forward(req, resp);
    }

}
