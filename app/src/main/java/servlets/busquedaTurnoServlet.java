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

        // fecha buscada
        LocalDate fechaBuscada = LocalDate.parse(req.getParameter("turnoBuscado"));

        //obtener la lista filtrada
        List<Turno> listaFiltrada = turnoController.listarTurnos(fechaBuscada,"tarde");
        System.out.println(listaFiltrada.get(0).getCiudadano());
        req.setAttribute("listado",listaFiltrada);

        req.getRequestDispatcher("listaTurnos.jsp").forward(req,response);





    }
}
