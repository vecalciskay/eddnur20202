package strategy.bien;

public class Skuiiiik extends Hablar {

	public Skuiiiik(Pato s) {
		sujeto = s;
	}
	@Override
	public void hablar() {
		// -- Lineas de codigo para implementar metodo
		System.out.println(sujeto.getNombre() + ": Skuiiiik");
		// -- Pueden ser cientos.
	}
}
