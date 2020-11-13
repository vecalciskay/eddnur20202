package arboles;

public class Numero extends ObjetoAritmetico {

	private double contenido;
	
	public Numero(double n) {
		contenido = n;
	}
	
	public double evaluar() {
		return contenido;
	}
	
	@Override
	public String toString() {
		return String.valueOf(contenido);
	}
}
