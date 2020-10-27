package arboles;

import listas.Lista;

public class Arbol<E> {

	class Nodo<E> {
		private String id;
		private Lista<Nodo<E>> hijos;
		private E contenido;
		private Nodo<E> padre;

		public Nodo(String nuevoId, E c) {
			hijos = new Lista<>();
			contenido = c;
			padre = null;
			id = nuevoId;
		}

		public String getId() {
			return id;
		}

		public Lista<Nodo<E>> getHijos() {
			return hijos;
		}

		public E getContenido() {
			return contenido;
		}

		public Nodo<E> getPadre() {
			return padre;
		}

		public void setPadre(Nodo<E> padre) {
			this.padre = padre;
		}

		public Nodo<E> encontrar(String idpadre) {
			if (this.id.equals(idpadre))
				return this;
			
			for(Nodo<E> hijo : hijos) {
				Nodo<E> encontro = hijo.encontrar(idpadre);
				if (encontro != null)
					return encontro;
			}
			
			return null;
		}
		
		@Override
		public String toString() {
			StringBuilder resultado = new StringBuilder();
			
			resultado.append(id);
			
			if (hijos.tamano() == 0)
				return resultado.toString();
			
			resultado.append("(");
			String separador = "";
			
			for(Nodo<E> hijo : hijos) {
				resultado.append(separador).append(hijo.toString());
				separador = ",";
			}
			resultado.append(")");
			
			return resultado.toString();
		}
	}

	private Nodo<E> raiz;

	public Arbol() {
		raiz = null;
	}

	public void insertar(E o, String id, String idpadre) {
		if (idpadre == null) {
			raiz = new Nodo<E>(id, o);
			return;
		}
		
		// Primero tenemos que encontrar el padre
		Nodo<E> padre = encontrar(idpadre);
		
		// Crear el nuevo nodo y colocarlo como hijo del padre encontrado
		Nodo<E> nuevoNodo = new Nodo<E>(id, o);
		padre.hijos.insertar(nuevoNodo);
		nuevoNodo.setPadre(padre);
	}

	private Nodo<E> encontrar(String padre) {
		return raiz.encontrar(padre);
	}
	
	@Override
	public String toString() {
		if (raiz == null)
			return "[VACIO]";
		return raiz.toString();
	}
}
