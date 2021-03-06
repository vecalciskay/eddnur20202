package listas;


public class ListaOrdenada<E> extends Lista<E> {

	public ListaOrdenada() {
		super();
	}
	
	@Override
	public void insertar(E o) {
		if (!(o instanceof Comparable)) {
			super.insertar(o);
			return;
		}
		
		// Si es el primer
		if (raiz == null) {
			super.insertar(o);
			return;
		}
		
		Comparable<E> c1 = (Comparable<E>)o;
		
		if (c1.compareTo(raiz.getContenido()) < 0)
		{
			super.insertar(o);
			return;
		}
		
		Nodo<E> actual = raiz;
		while(actual.getSiguiente() != null && c1.compareTo(actual.getSiguiente().getContenido()) > 0) {
			actual = actual.getSiguiente();
		}
		
		Nodo<E> nuevoNodo  = new Nodo<E>(o);
		nuevoNodo.setSiguiente(actual.getSiguiente());
		actual.setSiguiente(nuevoNodo);
	}
	
	@Override
	public E buscarSimple(E o) {
		int tamanio = this.tamano();
		return buscarEntre(0, tamanio, o);
	}

	private E buscarEntre(int i, int j, E o) {
		System.out.println("Busqueda DICOTOMICA");
		Comparable<E> c1 = (Comparable<E>)o;
		int mitad = i + (j - i) / 2;
		
		E encontrado = this.get(mitad);
		if (c1.compareTo(encontrado) == 0)
		{
			return encontrado;
		}
		
		if (i == j)
			return null;
		
		if (c1.compareTo(encontrado) < 0) {
			return buscarEntre(i, mitad, o);
		} else  {
			return buscarEntre(mitad, j, o);
		}
	}
}
