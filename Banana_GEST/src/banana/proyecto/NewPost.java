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

import com.google.gson.JsonObject;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import Classes.JSONPost;

/**
 * Servlet implementation class NewPost
 */
@WebServlet("/NewPost")
public class NewPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Tipo JSON
		response.setContentType("application/json");
		
		String jsonResult = "{\"status\":\"error\"}";
		
		Connection con = conectarAMySQL();
		if(con != null)
		{
			//System.out.println("Estoy conectado");
			
			JsonObject jo = JSONPost.getJsonObject(request.getReader());
			int id=jo.get("id").getAsInt();
			String contenido = jo.get("contenido").getAsString();
			
			//System.out.println(id);
			//System.out.println(contenido);
			
			String query = "INSERT INTO san_posts(pst_content, pst_control) VALUES('" + contenido + "', 1)";
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
				
				
				String queryId = "SELECT * FROM san_posts ORDER BY pst_id DESC LIMIT 1";
				
				ResultSet rs = (ResultSet) stmt.executeQuery(queryId);
				
				int rsId = 0;
				String rsContent = "";
				int rsControl = 0;
				
				while(rs.next())
				{
					rsId = rs.getInt("pst_id");
					rsContent = rs.getString("pst_content");
					rsControl = rs.getInt("pst_control");
				}
				
				 jsonResult = "{" + 
						                "\"id\":\"" + rsId +"\"," +
						                "\"content\":\"" + rsContent +"\"," + 
						                "\"control\":\"" + rsControl +"\"" + "}";
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
