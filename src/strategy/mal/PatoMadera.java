package strategy.mal;

public class PatoMadera extends Pato {
	public PatoMadera() {
		nombre = "Pato de madera";
	}
	@Override
	public void volar() {
		// -- Lineas de codigo para implementar metodo
		System.out.println(nombre + ": No vuela");
		// -- Pueden ser cientos.
	}

	@Override
	public void hablar() {
		// -- Lineas de codigo para implementar metodo
		System.out.println(nombre + ": No habla");
		// -- Pueden ser cientos.
	}
}
