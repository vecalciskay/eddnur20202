package recursividad.hanoi;

public class Anillo {

	private int tamano;
	
	public Anillo(int t) {
		tamano = t;
	}

	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

	@Override
	public String toString() {
		return Integer.toString(tamano);
	}
}
