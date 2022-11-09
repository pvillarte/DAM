package servlet.titulacion;

import java.io.IOException;

import model.Titulacion;
import repository.TitulacionRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/insert")
public class InsertDataServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	TitulacionRepository repository = new TitulacionRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Titulacion titulacion = getTitulacionFromRequest(req);
		repository.insert(titulacion);
		redirect(req, resp, "/feedback.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}