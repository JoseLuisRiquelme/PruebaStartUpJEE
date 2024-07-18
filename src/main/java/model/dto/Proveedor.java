package model.dto;

public class Proveedor {
	
	private String nombre;
	private String rubro;
	private String telefono;
	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Proveedor(String nombre, String rubro, String telefono) {
		super();
		this.nombre = nombre;
		this.rubro = rubro;
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRubro() {
		return rubro;
	}
	public void setRubro(String rubro) {
		this.rubro = rubro;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Proveedor [nombre=" + nombre + ", rubro=" + rubro + ", telefono=" + telefono + "]";
	}
	

}
