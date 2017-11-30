

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class Prueba
 */
@WebServlet(
		description = "Mi primer servlet para hacer pruebas", 
		urlPatterns = { "/Prueba" }
		)
public class Prueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prueba() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String dato = "";
		dato = request.getParameter("nombre"); //asigna la llave y devuelve valor
		Persona persona = new Persona();
		Gson gson = new Gson();
		persona = gson.fromJson(dato, Persona.class);
		
		PrintWriter miPrintWriter = new PrintWriter(response.getWriter());
		System.out.println(persona.getNombre());
		miPrintWriter.println(dato); //Regresa el dato al post
	}

}
