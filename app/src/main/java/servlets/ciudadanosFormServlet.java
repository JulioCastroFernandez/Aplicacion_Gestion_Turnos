package servlets;

import controllers.CiudadanoController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/ciudadanoForm")
public class ciudadanosFormServlet extends HttpServlet {

    private final CiudadanoController ciudadanoController = new CiudadanoController();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //devolvemoa a la vista
        req.getRequestDispatcher("ciudadanoForm.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //rgogemos los datos
        String dni = request.getParameter("dni") ;
        String nombre = request.getParameter("nombre") ;
        String apellido = request.getParameter("apellido") ;

        //creacion objecto
        ciudadanoController.crearCiudadano(dni,nombre,apellido);

        response.sendRedirect("/app/listaCiudadanos");

    }

    }
