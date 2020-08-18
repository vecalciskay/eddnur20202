package observer;

import java.beans.PropertyChangeSupport;

public class Profesor {

	private String nombre;

	private PropertyChangeSupport cambios;
	
	public Profesor(String nombre) {
		this.setNombre(nombre);
		cambios = new PropertyChangeSupport(this);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void saleCurso() {
		System.out.println("[" + nombre + "]: Sale del curso");
		cambios.firePropertyChange("SALIR", false, true);
	}

	public void llegaCurso() {
		System.out.println("[" + nombre + "]: Llega al curso");
		cambios.firePropertyChange("LLEGAR", false, true);
	}

	public void addObservador(Alumno a) {
		cambios.addPropertyChangeListener(a);
	}


}
