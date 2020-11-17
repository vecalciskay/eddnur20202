package arboles;

public class Operacion extends ObjetoAritmetico {

	private Operador operador;
	
	public Operacion(Operador op) {
		operador = op;
	}
	
	@Override
	public String toString() {
		if (operador == Operador.suma)
			return "+";
		if (operador == Operador.resta)
			return "-";
		if (operador == Operador.multiplicacion)
			return "*";
		if (operador == Operador.division)
			return "/";
		return super.toString();
	}
	
	public double evaluar(double izq, double der) {
		if (operador == Operador.suma)
			return izq + der;
		if (operador == Operador.resta)
			return izq - der;
		if (operador == Operador.multiplicacion)
			return izq * der;
		if (operador == Operador.division)
			return izq / der;
		// no deberia lllegar aca
		return 0;
	}
	
	public static Operador ParseOperador(String s) throws Exception {
		if (s.equals("+"))
			return Operador.suma;
		if (s.equals("-"))
			return Operador.resta;
		if (s.equals("*"))
			return Operador.multiplicacion;
		if (s.equals("/"))
			return Operador.division;
		
		throw new Exception("No pudo leer operacion");
	}
}
