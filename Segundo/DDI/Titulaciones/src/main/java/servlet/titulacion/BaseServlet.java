package servlet.titulacion;

import java.io.IOException;

import model.Titulacion;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public BaseServlet() {
		super();
	}

	protected Titulacion getTitulacionFromRequest(HttpServletRequest req) {
		Titulacion titulacion = new Titulacion();
		titulacion.setId(Integer.parseInt(req.getParameter("id")));
		System.out.println(titulacion.getId());
		titulacion.setTitulo(req.getParameter("titulo"));
		System.out.println(titulacion.getTitulo());
		return titulacion;
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String jsp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(req, resp);
	}

}