package banana.proyecto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class ObtainPost
 */
@WebServlet("/ObtainPost")
public class ObtainPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtainPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//processRequest(request, response);
		
		//Indicar que retornaremos un json
		response.setContentType("application/json");
		
		//JSON por defecto
		String jsonResult = "{\"status\":\"error\"}";
		
		//Conectar a la base de datos
		Connection con = conectarAMySQL();
		
		//Si la conexion fue exitosa realizamos el proceso.
		if(con != null)
		{
			//Creamos la query
			String query = "SELECT * FROM san_posts WHERE pst_control = 1 ORDER BY pst_id DESC";
			
			//Consulta
			
			try {
				Statement stmt = (Statement) con.createStatement();
				
				ResultSet rs = (ResultSet) stmt.executeQuery(query);
				
				jsonResult = "";
				
				String jsonCurrent = "";
				
				JsonArray jArray = new JsonArray();
				
				while(rs.next())
				{
					//Creando el JSON actual
					int rsId = rs.getInt("pst_id");
					String rsContent = rs.getString("pst_content");
					int rsControl = rs.getInt("pst_control");
					
					//Declarar un nuevo JsonObject, para la publicacion actual
					JsonObject jobj = new JsonObject();
					
					//Asignar los valores al nuevo json object
					jobj.addProperty("id", rsId);
					jobj.addProperty("content", rsContent);
					jobj.addProperty("control", rsControl);
					
					jArray.add(jobj);
					
				}
				
				//jsonResult = "{\"posts\": ["+ jsonCurrent +"]}";
				
				//FORMA 1:
				
				/*
				Gson gson = new Gson();
				jsonResult = gson.toJson(jArray);
				*/
				
				//FORMA 2:
				jsonResult = jArray.toString();
				
				//jsonResult = "{\"posts\":" + jArray.toString() +
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		//Escribir el json
		try(PrintWriter out = response.getWriter())
		{
			out.print(jsonResult);
		}
	}
	
	public Connection conectarAMySQL()
    {
        Connection conn1 = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sandia","root","christiancogr93");
            
           
            
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
