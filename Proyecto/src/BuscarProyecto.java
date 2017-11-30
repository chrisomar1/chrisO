

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
 * Servlet implementation class BuscarProyecto
 */
@WebServlet("/BuscarProyecto")
public class BuscarProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarProyecto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("application/json");
			
			String jsonResult = "{\"id\":\"error\",\"nombre\":\"unknown\"}";  //status:
			
			Connection con = conectarAMySQL();
			if(con != null)
			{
				//System.out.println("Estoy conectado");
				
				JsonObject jo = JSONPost.getJsonObject(request.getReader());
				String id=jo.get("id").getAsString();

				
				//System.out.println(id);
				//System.out.println(contenido);
				
				String query = "select * from usuarios where id_usuario='"+id+"'";
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
					//stmt.executeUpdate(query);
					
					
					//String queryId = "SELECT * FROM proyecto ORDER BY idproyecto DESC LIMIT 1";
					
					ResultSet rs = (ResultSet) stmt.executeQuery(query);
					System.out.println(rs);
					if(rs.next())
					{
						String rsNombre = rs.getString("nombre");
					 jsonResult = "{" + 
							                "\"id\":\"" + id +"\"" + ","+
							                "\"nombre\":\"" + rsNombre +"\"" +
		
							                "}";}
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
