package strategy.bien;

import strategy.IPato;

public abstract class Pato implements IPato {
	protected String nombre;
	
	protected Volar estrategiaVolar;
	protected Hablar estrategiaHablar;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void volar() {
		estrategiaVolar.volar();
	}
	
	@Override
	public void hablar() {
		estrategiaHablar.hablar();
	}
}
