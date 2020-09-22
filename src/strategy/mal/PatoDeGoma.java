package strategy.mal;

public class PatoDeGoma extends Pato {

	public PatoDeGoma() {
		nombre = "Pato de goma";
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
		System.out.println(nombre + ": skuiiiik");
		// -- Pueden ser cientos.
	}

}
