package banana.proyecto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shaded.com.google.gson.Gson;

/**
 * Servlet implementation class RespuestaAJAX
 */
@WebServlet(name = "/RespuestaAJAX", urlPatterns={"/respuesta-ajax"})
public class RespuestaAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String valor = "";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RespuestaAJAX() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-gene rated method stub
		/*String valor = request.getParameter("dato");
		
		PrintWriter pw = response.getWriter();
		pw.print("{\"dato\":\"0\"}");*/
		
		//La ruta va a devolver un JSON
		   
		 response.setContentType("application/json");
		 Usuario usuario = new Usuario();
		 Gson gson = new Gson();
		 valor = request.getParameter("dato");
		 
		 System.out.println(valor+" , "+"{\"dato\": \"hola mundo\",\"dato2\":\"hola Katarino\"}");
		 PrintWriter pw = response.getWriter();
		 pw.print("{\"dato\": \"hola mundo\",\"dato2\":\"hola Katarino\"}");
		    
		//Obtener parámetros
		    
		
	}

}
