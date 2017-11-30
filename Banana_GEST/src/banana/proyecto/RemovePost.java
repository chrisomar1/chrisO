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
import com.mysql.jdbc.Statement;

import Classes.JSONPost;

/**
 * Servlet implementation class RemovePost
 */
@WebServlet("/RemovePost")
public class RemovePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemovePost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
 // Remove Post


 protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
         //processRequest(request, response);
         
         //Devolver JSON
         response.setContentType("application/json");
         
         //JSON Por defecto
         String jsonResult = "{\"status\":\"error\"}";
         
         //Conectar a la base de datos
         Connection con = conectarAMySQL();

         //Si la conexión fue exitosa relizamos el proceso
         if (con != null) {
             //Send request reader and get
             JsonObject jo = JSONPost.getJsonObject(
                 request.getReader() //Aquí está nuestro json
             );
             
             int id = jo.get("id").getAsInt();
             
             //Creamos la query
             String query = "UPDATE san_posts SET pst_control = 0 WHERE pst_id = " + id;
             //System.out.println(query);
             
             try {
                 //Consulta
                 Statement stmt = (Statement) con.createStatement();
                 
                 //ResultSet rs   =  stmt.executeUpdate(query);
                 stmt.executeUpdate(query);
                 
                 con.close();
                 
                 JsonObject jobj = new JsonObject();
                 jobj.addProperty("id", id);
                 jobj.addProperty("status", "ok");
                 jsonResult = jobj.toString();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
             
         }
         
         //Escribir JSON
         try (PrintWriter out = response.getWriter()) {
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
