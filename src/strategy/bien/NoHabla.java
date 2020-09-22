package strategy.bien;

public class NoHabla extends Hablar {

	public NoHabla(Pato s) {
		sujeto = s;
	}

	@Override
	public void hablar() {
		// -- Lineas de codigo para implementar metodo
		System.out.println(sujeto.getNombre() + ": No habla");
		// -- Pueden ser cientos.
	}

}
