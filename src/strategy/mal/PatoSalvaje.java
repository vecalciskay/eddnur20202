package strategy.mal;

public class PatoSalvaje extends Pato {
	public PatoSalvaje() {
		nombre = "Pato salvaje";
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
