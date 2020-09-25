package listas;

public class ListaSimple {

	private NodoSimple raiz;
	
	public ListaSimple() {
		raiz = null;
	}

	public NodoSimple getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoSimple raiz) {
		this.raiz = raiz;
	}
	
	/**
	 * Operacion insertar:
	 * Lista antes: X -> M -> H
	 * Objeto a insertar: E
	 * Lista despues: E -> X -> M -> H
	 * @param o
	 */
	public void insertar(Object o) {
		NodoSimple nuevo = new NodoSimple(o);
		
		nuevo.setSiguiente(raiz);
		raiz = nuevo;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		NodoSimple actual = raiz;
		while(actual != null) {
			result.append(actual.getContenido()).append(" -> ");
			actual = actual.getSiguiente();
		}
		if (result.length() == 0)
			return "[VACIA]";
		
		return result.toString();
	}
}
