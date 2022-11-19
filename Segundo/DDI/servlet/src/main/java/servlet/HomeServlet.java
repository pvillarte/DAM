package servlet;

import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/myHomeServlet")
public class HomeServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        // Setting Some Sample Attributes In The Request Scope
        String nombre= "Manolo Cabeza Bolo";
        request.setAttribute("personReqObj", nombre);
 
        RequestDispatcher dispatcherObj = getServletContext().getRequestDispatcher("/home.jsp");
        dispatcherObj.forward(request, response);
    }
}