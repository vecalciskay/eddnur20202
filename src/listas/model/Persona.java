package listas.model;

import java.util.Date;

public class Persona implements Identificable<Long>, Comparable<Persona> {

	private String nombre;
	private long carnet;
	private Date fechaNacimiento;
	private String profesion;
	
	public Persona(String nom, long ci) {
		nombre = nom;
		carnet = ci;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getProfesion() {
		return profesion;
	}
	
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getNombre() {
		return nombre;
	}

	public long getCarnet() {
		return carnet;
	}

	@Override
	public boolean seIdentificaPor(Long o) {
		return o.longValue() == carnet;
	}

	@Override
	public Long getId() {
		return Long.valueOf(carnet);
	}
	
	@Override
	public String toString() {
		String result =nombre + "(" + carnet + "): ";
		if (fechaNacimiento != null)
			result += fechaNacimiento.toString();
		return result;
	}

	@Override
	public int compareTo(Persona o) {
		return nombre.compareTo(o.getNombre());
	}
}
