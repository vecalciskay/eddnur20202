package observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Alumno implements PropertyChangeListener{

	private String nombre;

	public Alumno(String nombre) {
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void comienzaExamen() {
		System.out.println("[" + nombre + "]: Comienza su examen");
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("SALIR")) {
			System.out.println("[" + nombre + "]: Comienza a copiar");
		}
		if (evt.getPropertyName().equals("LLEGAR")) {
			System.out.println("[" + nombre + "]: Se pone en modo serio");
		}
	}

}
