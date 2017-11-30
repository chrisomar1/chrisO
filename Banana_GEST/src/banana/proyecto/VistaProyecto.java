package banana.proyecto;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import banana.util.LectorPropiedades;
import shaded.com.mongodb.BasicDBObject;
import shaded.com.mongodb.DB;
import shaded.com.mongodb.DBCollection;
import shaded.com.mongodb.DBCursor;
import shaded.com.mongodb.DBObject;
import shaded.com.mongodb.MongoClient;


/**
 * Servlet implementation class VistaProyecto
 */
@WebServlet("/VistaProyecto")
public class VistaProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VistaProyecto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String dato = request.getParameter("dato");
		//String nombre = request.getParameter("nombre");
		System.out.println("Iniciando conexión: "+dato);
		
		//ejecutarPreparedStatement();
		conectarAMongo();
	}
	
	
	public void conectarAMongo()
	{
		try {
			MongoClient client = new MongoClient("localhost",27017);
			DB db = client.getDB("pruebas");
			System.out.println("Connect to database successfully");
			DBCollection coll = db.createCollection("micoleccion",null);
			System.out.println("Collection created successfully");
			//
			boolean auth = db.authenticate("root", "christiancogr93".toCharArray());
			System.out.println("Authentication: "+auth);
			coll = db.getCollection("prueba");
			System.out.println("Got collection");
			
			//Insertar un documento
			BasicDBObject doc = new BasicDBObject("title", "MongoDB del aula 4").
					append("description", "una inserción").
					append("numero", 3).
					append("by", "Christian");
					coll.insert(doc);
					System.out.println("Insert done");
					//Insertar mucho documentos
					for(int x=0; x<100; x++)
					{
						        doc = new BasicDBObject("title", "MongoDB del aula 4").
								append("description", "una inserción").
								append("numero", x).
								append("by", "Christian");
								coll.insert(doc);
								System.out.println("Insert "+x+" done...");
					}
					
					DBCursor cursor = coll.find();
					//Actualizar documento
					/*while (cursor.hasNext()) {
						DBObject updateDocument = cursor.next();
						updateDocument.put("actializacion","2/11/2017");
						BasicDBObject searchQuery = new BasicDBObject().append("by", "christian");
						coll.update(searchQuery, updateDocument);
						}*/
				
					//Obtener documentos de la colección
					//DBCursor cursor = coll.find(); //Todos los documento
					int i = 1;
					while (cursor.hasNext()) 
					{
					System.out.println("Inserted Document: "+i);
					System.out.println(cursor.next());
					i++;
					}
					
					//Eliminar una colección.
					DBObject myDoc = coll.findOne();
					coll.remove(myDoc);
					cursor = coll.find();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Método público
	 * Se encarga de consultar n registros de la base de datos 
	 * y luego los inserta para duplicarlos.
	 */
	
	public void consultarEInsertar()
	{
		Statement stmt;
		ResultSet rs;
		ListaUsuario lista = new ListaUsuario();
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		LectorPropiedades properties = new LectorPropiedades();
		//Conectarse a MySQL con esta plantilla 
		try {
			/*Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banana_gest", "root", "christiancogr93");*/
			String url = properties.getPropValues().getProperty("url");
			String user = properties.getPropValues().getProperty("user");
			String pass = properties.getPropValues().getProperty("password");
			String dbdriver = properties.getPropValues().getProperty("dbdriver");
			
			Class.forName(dbdriver).newInstance();
			Connection conexion = (Connection) DriverManager.getConnection(url, user, pass);
			if(conexion==null)
			{
				System.out.println("Error de capa 8 en delante!!!");	
			}
			else
			{//Sí sirvió
				// Bandera de autocommit | Autocommit está desactivado
				conexion.setAutoCommit(false);
				System.out.println("Conexión realizada!!!");
				stmt = (Statement) conexion.createStatement();
				rs = (ResultSet) stmt.executeQuery("select * from usuarios;");
				while(rs.next() != false)
				{
					//System.out.println(rs.getInt("idusuarios")+" , "+rs.getString("nombre")+" , "+rs.getString("correo")+" , "+rs.getString("contrasenia")+" , "+rs.getString("cel"));
					Usuario usuario = new Usuario(rs.getInt("idusuarios"),rs.getString("nombre"),rs.getString("correo"),rs.getString("contrasenia"),rs.getString("cel"));
					listaUsuario.add(usuario);
				}
				
				lista.setListaUsuario(listaUsuario);
				for(int x=0; x<lista.getListaUsuario().size();x++)
				{
					System.out.println(lista.getListaUsuario().get(x).getIdusuarios()+" , "+lista.getListaUsuario().get(x).getNombre()+" , "
							+lista.getListaUsuario().get(x).getCorreo()+" , "+lista.getListaUsuario().get(x).getContrasenia()
							+lista.getListaUsuario().get(x).getCel());
					stmt.executeUpdate("insert into usuarios (nombre,correo,contrasenia, cel) values "
							+ "('"+lista.getListaUsuario().get(x).getNombre()+"','"
							+lista.getListaUsuario().get(x).getCorreo()+"','"
							+lista.getListaUsuario().get(x).getContrasenia()+"','"
							+lista.getListaUsuario().get(x).getCel()+"');");
				}
				conexion.commit();
				conexion.close(); //Cerramos la conexion con la base de datos.
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	/**
	 * Método público.
	 * Se encarga de realizar una consulta usando la 
	 * clase PreparedStatement.
	 */
	
	public void ejecutarPreparedStatement()
	{
		//Connection conn = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banana_gest", "root", "christiancogr93");
		    PreparedStatement pstmt = (PreparedStatement) conn1.prepareStatement("select * from usuarios where nombre = ?;");
            pstmt.setString(1, "franz");
			ResultSet rs = (ResultSet) pstmt.executeQuery();
			
			while(rs.next() != false)
			{
				System.out.println(rs.getInt("idusuarios")+" , "+rs.getString("nombre")+" , "+rs.getString("correo")+" , "+rs.getString("contrasenia")+" , "+rs.getString("cel"));
				//Usuario usuario = new Usuario(rs.getInt("idusuarios"),rs.getString("nombre"),rs.getString("correo"),rs.getString("contrasenia"),rs.getString("cel"));
				//listaUsuario.add(usuario);
			}
			conn1.close();
		
		}
		catch (SQLException e) {
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
		
	}
	
	/*public void usarPool() throws ServletException
	{
		//Obtener el DataSource
				Context initContext;
				try {
					initContext = new InitialContext();
					Context envContext = (Context) initContext.lookup("jdbc/banana_gest");
					DataSource dataSource = (DataSource) envContext.lookup("jdbc/banana_gest");
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		try{
			Connection conn1 = (Connection) dataSource.getConnection();
			
			conn1.close();
		
		}
		catch (SQLException e) {
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
	}*/
	
	public void iniciarPool() throws ServletException //Te manda una excepción general del objeto no de lo que contiene el objeto
	{
		//Obtener el DataSource
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("jdbc/banana_gest");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/banana_gest");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
