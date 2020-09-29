package listas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Iterator;

public class Lista<E> implements Iterable<E> {

	static class Nodo<E> {
		private E contenido;
		private Nodo<E> siguiente;
		
		public Nodo(E o) {
			contenido = o;
			siguiente = null;
		}

		public E getContenido() {
			return contenido;
		}

		public void setContenido(E contenido) {
			this.contenido = contenido;
		}

		public Nodo<E> getSiguiente() {
			return siguiente;
		}

		public void setSiguiente(Nodo<E> siguiente) {
			this.siguiente = siguiente;
		}		
	}
	
	static class Iterador<E> implements Iterator<E> {

		private Nodo<E> actual;
		
		public Iterador(Lista<E> lista) {
			actual = lista.getRaiz();
		}
		@Override
		public boolean hasNext() {

			System.out.println("OP");
			return actual != null;
		}

		@Override
		public E next() {

			System.out.println("OP");
			E siguienteObjeto = actual.getContenido();
			actual = actual.getSiguiente();
			return siguienteObjeto;
		}
		
	}
	
	private PropertyChangeSupport cambio;
	private Nodo<E> raiz;
	
	public Lista() {
		raiz = null;
		cambio = new PropertyChangeSupport(this);
	}

	public Nodo<E> getRaiz() {
		return raiz;
	}
	
	public void observador(PropertyChangeListener listener) {
		this.cambio.addPropertyChangeListener(listener);
	}

	public void setRaiz(Nodo<E> raiz) {
		this.raiz = raiz;
	}
	
	/**
	 * Operacion insertar:
	 * Lista antes: X -> M -> H
	 * Objeto a insertar: E
	 * Lista despues: E -> X -> M -> H
	 * @param o
	 */
	public void insertar(E o) {
		Nodo<E> nuevo = new Nodo<E>(o);
		
		nuevo.setSiguiente(raiz);
		raiz = nuevo;
		cambio.firePropertyChange("INSERT", 0, 1);
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		Nodo<E> actual = raiz;
		while(actual != null) {
			result.append(actual.getContenido()).append(" -> ");
			actual = actual.getSiguiente();
		}
		if (result.length() == 0)
			return "[VACIA]";
		
		return result.toString();
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterador<E>(this);
	}
	
	public int tamano() {
		int t = 0;
		for(E o : this) {
			t++;
			System.out.println("OP");
		}
		return t;
	}
	
	public E get(int i) {
		int posicionActual = 0;
		Nodo<E> actual = raiz;
		while(actual != null && posicionActual < i) {

			System.out.println("OP");
			posicionActual++;
			actual = actual.getSiguiente();
		}
		
		if (actual == null)
			return null;
		

		System.out.println("OP");
		return actual.getContenido();
	}
}
