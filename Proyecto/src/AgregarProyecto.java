

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
 * Servlet implementation class AgregarProyecto
 */
@WebServlet("/AgregarProyecto")
public class AgregarProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarProyecto() {
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
			String nombreproyecto=jo.get("nombreproyecto").getAsString();
			String descripcion = jo.get("descripcion").getAsString();
			String fechainicio = jo.get("fechainicio").getAsString();
			String fechafin = jo.get("fechafin").getAsString();
			int estado = jo.get("estado").getAsInt();
			int miembros = jo.get("miembros").getAsInt();
			
			//System.out.println(id);
			//System.out.println(contenido);
			
			String query = "INSERT INTO proyecto(nombreproyecto,descripcion,fechainicio,fechafin,estado,miembros) VALUES('" + nombreproyecto + "', '"+ descripcion +"', '"+ fechainicio +"', '"+fechafin+"', '"+estado+"', '"+miembros+"')";
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
				
				
				String queryId = "SELECT * FROM proyecto ORDER BY idproyecto DESC LIMIT 1";
				
				ResultSet rs = (ResultSet) stmt.executeQuery(queryId);
				
				int idProyecto = 0;
				String nombreProyecto = "";
				String descripcionProyecto = "";
				String fechainiProyecto = "";
				String fechafinProyecto = "";
				int estadoProyecto = 0;
				int miembrosProyecto = 0;
				
				while(rs.next())
				{
					idProyecto = rs.getInt("idproyecto");
					nombreProyecto = rs.getString("nombreproyecto");
					descripcionProyecto = rs.getString("descripcion");
					fechainiProyecto = rs.getString("fechainicio");
					fechafinProyecto = rs.getString("fechafin");
					estadoProyecto = rs.getInt("estado");
					miembrosProyecto = rs.getInt("miembros");
				}
				
				 jsonResult = "{" + 
						                "\"id\":\"" + idProyecto +"\"," +
						                "\"nombre\":\"" + nombreProyecto +"\"," + 
						                "\"descripcion\":\"" + descripcionProyecto +"\"," + 
						                "\"fechainicio\":\"" + fechainiProyecto +"\"," + 
						                "\"fechafin\":\"" + fechafinProyecto +"\"," +
						                "\"estado\":\"" + estadoProyecto +"\"," +
						                "\"miembros\":\"" + miembrosProyecto +"\"" +
						                "}";
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
