package strategy.bien;

public class Vuela extends Volar {

	public Vuela(Pato s) {
		sujeto = s;
	}
	@Override
	public void volar() {
		// -- Lineas de codigo para implementar metodo
		System.out.println(sujeto.getNombre() + ": Vuela");
		// -- Pueden ser cientos.
	}

}
