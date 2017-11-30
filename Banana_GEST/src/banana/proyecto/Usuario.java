package banana.proyecto;

public class Usuario 
{
	private int idusuarios;
	private String nombre;
	private String correo;
	private String contrasenia;
	private String cel;
	
	public Usuario()
	{
		
	}
	
	public Usuario(int id, String nom, String corr, String contr, String celu)
	{
		setIdusuarios(id);
		setNombre(nom);
		setCorreo(corr);
		setContrasenia(contr);
		setCel(celu);
	}

	public int getIdusuarios() {
		return idusuarios;
	}

	public void setIdusuarios(int idusuarios) {
		this.idusuarios = idusuarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}
	
	

}
