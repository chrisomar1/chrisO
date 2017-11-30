package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import Classes.JSONPost;

/**
 * Servlet implementation class AgregarUsuario
 */
@WebServlet("/AgregarUsuario")
public class AgregarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 response.setContentType("application/json");
			
			String jsonResult = "{\"status\":\"error\"}";
			
			Connection con = conectarAMySQL();
			
			if(con != null)
			{
				//System.out.println("Estoy conectado");
				
				JsonObject jo = JSONPost.getJsonObject(request.getReader());
				//String id_usuario=jo.get("id_usuario").getAsString();
				String nombre = jo.get("nombre").getAsString();
				String correo = jo.get("correo").getAsString();
				String contrasena = jo.get("contrasena").getAsString();
		
				
				//System.out.println(id);
				//System.out.println(contenido);
				
				String query = "insert into usuarios (nombre,correo,contrasena) values ('"+ nombre +"', '"+ correo +"', '"+contrasena+"')";
				System.out.println(query);
				
				try {
					
					//Consulta
					Statement stmt = (Statement) con.createStatement();
					/*ResultSet rs = (ResultSet) stmt.executeQuery("");
					while(rs.next())
					{
						rs.getString("");
					}*/
					
					//Insercion
					stmt.executeUpdate(query);
					
					
					String queryId = "SELECT * FROM usuarios ORDER BY id_usuario DESC LIMIT 1";
					
					ResultSet rs = (ResultSet) stmt.executeQuery(queryId);
					
					int idUsuario = 0;
					String nombreUsuario = "";
					String correoUsuario = "";
					String contrasenaUsuario = "";

					
					while(rs.next())
					{
						idUsuario = rs.getInt("id_usuario");
						nombreUsuario = rs.getString("nombre");
						correoUsuario = rs.getString("correo");
						contrasenaUsuario = rs.getString("contrasena");

					}
					
					 /*jsonResult = "{" + 
							                "\"id\":\"" + idUsuario +"\"," +
							                "\"nombre\":\"" + nombreUsuario +"\"," + 
							                "\"correo\":\"" + correoUsuario +"\"," + 
							                "\"contrasena\":\"" + contrasenaUsuario + "\"" +
							                "}";*/
					
					jsonResult = "{\"status\":\"success\"}";
					 System.out.println(jsonResult);
					con.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
			
			 
			//Escribir el JSON
			try(PrintWriter out = response.getWriter()){
				//out.print("{\"dato\": \"No que no entrabas\"}");
				out.print(jsonResult);
			    System.out.println(jsonResult);
			    System.out.println(out);
			}
			
			
			
	}
	
    public Connection conectarAMySQL()
    {
        Connection conn1 = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/manzana","root","christiancogr93");
            
           
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn1;
    }


}
