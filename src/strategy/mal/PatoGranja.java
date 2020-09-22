package strategy.mal;

public class PatoGranja extends Pato {
	public PatoGranja() {
		nombre = "Pato de granja";
	}
	@Override
	public void volar() {
		// -- Lineas de codigo para implementar metodo
		System.out.println(nombre + ": Vuela");
		// -- Pueden ser cientos.
	}

	@Override
	public void hablar() {
		// -- Lineas de codigo para implementar metodo
		System.out.println(nombre + ": cuac");
		// -- Pueden ser cientos.
	}
}
