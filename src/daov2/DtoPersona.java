package daov2;

public class DtoPersona extends Dto{
	
	private String nombre;
	
	public DtoPersona() {
		
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
