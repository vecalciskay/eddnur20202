package recursividad.hanoi;

import java.util.Iterator;
import java.util.Stack;

public class Torre {

	private Stack<Anillo> anillos;
	
	public Torre() {
		anillos = new Stack<>();
	}

	public void meter(Anillo anillo) {
		anillos.push(anillo);
	}
	
	public Anillo sacar() {
		return anillos.pop();
	}
	
	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder();
		resultado.append("|-");
		for (Iterator<Anillo> iterator = anillos.iterator(); iterator.hasNext();) {
			Anillo anillo = iterator.next();
			resultado.append(anillo).append("-");
		}
		return resultado.toString();
	}

	public int cantidad() {
		return anillos.size();
	}

	public Stack<Anillo> getAnillos() {
		return anillos;
	}
	
}
