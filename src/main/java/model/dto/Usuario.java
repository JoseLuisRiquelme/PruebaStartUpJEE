package model.dto;

public class Usuario {
	
	private int id;
	private String correo;
	private String nick;
	private String nombre;
	private String password;
	private int peso;
	private int rolId;
	private String calle;
	private String numeracion;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int id, String correo, String nick, String nombre, String password, int peso) {
		super();
		this.id = id;
		this.correo = correo;
		this.nick = nick;
		this.nombre = nombre;
		this.password = password;
		this.peso = peso;
	}
	
	public Usuario( String correo, String nick, String nombre, String password, int peso, int rolId, String calle, String numeracion) {
		super();
		this.correo = correo;
		this.nick = nick;
		this.nombre = nombre;
		this.password = password;
		this.peso = peso;
		this.rolId =rolId;
		this.calle=calle;
		this.numeracion=numeracion;
	}
	
	public Usuario( String correo, String password) {
		super();
		this.correo = correo;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	

	public int getRolId() {
		return rolId;
	}

	public void setRolId(int rolId) {
		this.rolId = rolId;
	}
	

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeracion() {
		return numeracion;
	}

	public void setNumeracion(String numeracion) {
		this.numeracion = numeracion;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", correo=" + correo + ", nick=" + nick + ", nombre=" + nombre + ", password="
				+ password + ", peso=" + peso +  ", rolId=" + rolId +", calle=" + calle +", numeracion=" + numeracion +"]";
	}
	
	
	
	

}
