package servlets;

import controllers.CiudadanoController;
import entities.Ciudadano;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/listaCiudadanos")
public class ciudadanosServlet extends HttpServlet {
    private final CiudadanoController ciudadanoController = new CiudadanoController();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Ciudadano> lista = ciudadanoController.listarCiudadanos();

        //envio de datos a la vista
        req.setAttribute("listado", lista);
        //devolvemos a la vista
        req.getRequestDispatcher("listaCiudadanos.jsp").forward(req, resp);
    }

}
