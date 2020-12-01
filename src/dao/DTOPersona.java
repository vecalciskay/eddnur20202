package dao;

public class DTOPersona {

	private int id;
	private String nombre;
	
	public DTOPersona() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Id: " + id + " Nombre: " + nombre;
	}
}
