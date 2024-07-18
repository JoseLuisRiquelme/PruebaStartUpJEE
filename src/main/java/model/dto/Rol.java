package model.dto;

public class Rol {
	
	private int id;
	private String nombreRol;
	private String descripcionRol;
	
	public Rol() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rol(int id, String nombreRol, String descripcionRol) {
		super();
		this.id = id;
		this.nombreRol = nombreRol;
		this.descripcionRol = descripcionRol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public String getDescripcionRol() {
		return descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}
	
	
	
	

}
