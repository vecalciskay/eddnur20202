package strategy.bien;

public class NoVuela extends Volar {

	public NoVuela(Pato s) {
		sujeto = s;
	}
	@Override
	public void volar() {
		// -- Lineas de codigo para implementar metodo
		System.out.println(sujeto.getNombre() + ": No vuela");
		// -- Pueden ser cientos.
	}

}
