package servlets;
import controllers.TurnoController;
import entities.Turno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/listaTurnos")
public class turnosServlet extends HttpServlet {

    private final TurnoController turnoController = new TurnoController();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Turno> todos = turnoController.listarTodosTurnos();

        req.setAttribute("listado", todos);
        //devolvemos la vista
        req.getRequestDispatcher("listaTurnos.jsp").forward(req, resp);
    }

}
