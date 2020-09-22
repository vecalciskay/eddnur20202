package strategy.bien;

public class Cuac extends Hablar {

	public Cuac(Pato s) {
		sujeto = s;
	}
	@Override
	public void hablar() {
		// -- Lineas de codigo para implementar metodo
		System.out.println(sujeto.getNombre() + ": cuac");
		// -- Pueden ser cientos.
	}

}
