package servlets;


import controllers.TurnoController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/turnoForm")
public class turnosFormServlet extends HttpServlet {

    private final TurnoController turnoController = new TurnoController();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //devolvemoa a la vista
        req.getRequestDispatcher("turnoForm.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //se recogen los datos
        String estado = request.getParameter("tipo-turno");
        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
        Long id = Long.valueOf(1);
        System.out.println(turnoController);
        //creacion objecto
        turnoController.crearTurno(estado,fecha,id);

        response.sendRedirect("/app/listaTurnos");

    }
}
