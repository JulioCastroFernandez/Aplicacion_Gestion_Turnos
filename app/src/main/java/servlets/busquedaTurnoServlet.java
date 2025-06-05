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
import java.util.List;
@WebServlet(urlPatterns = "/busquedaForm")
public class busquedaTurnoServlet extends HttpServlet {

    private final TurnoController turnoController = new TurnoController();
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        String fechaBuscadaString = req.getParameter("fecha");
        String estado = req.getParameter("estado");

        List<Turno> filtrados = List.of();
        boolean tieneFecha = fechaBuscadaString != null && !fechaBuscadaString.isBlank();
        boolean tieneEstado = estado != null && !estado.isBlank();

        LocalDate fechaBuscada = LocalDate.parse(fechaBuscadaString);
        if (tieneFecha && tieneEstado) {
            filtrados = turnoController.listarTurnos(fechaBuscada, estado);
        } else if (!tieneFecha && !tieneEstado) {
            filtrados = turnoController.listarTodosTurnos();
        } else if (tieneFecha) {
            filtrados = turnoController.listarPorFecha(fechaBuscada);
        } else {
            filtrados = turnoController.listarPorEstado(estado);
        }



        req.setAttribute("estado", estado);
        req.setAttribute("fecha",fechaBuscadaString);
        req.setAttribute("listado", filtrados);
        //devolvemos la vista

        req.getRequestDispatcher("listaTurnos.jsp").forward(req,response);


    }
}
