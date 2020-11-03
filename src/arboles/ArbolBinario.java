package arboles;

public class ArbolBinario<E> {
	class Nodo<E> {
		private String id;
		private Nodo<E> izquierda;
		private Nodo<E> derecha;
		private E contenido;
		private Nodo<E> padre;

		public Nodo(String nuevoId, E c) {
			contenido = c;
			padre = null;
			id = nuevoId;
			izquierda = null;
			derecha = null;
		}

		public String getId() {
			return id;
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

			Nodo<E> encontro = null;
			if (izquierda != null) {
				encontro = izquierda.encontrar(idpadre);
				if (encontro != null)
					return encontro;
			}
			
			if (derecha != null) {
				encontro = derecha.encontrar(idpadre);
				if (encontro != null)
					return encontro;
			}
			return null;
		}

		@Override
		public String toString() {
			StringBuilder resultado = new StringBuilder();

			resultado.append(id);

			if (izquierda == null && derecha == null)
				return resultado.toString();

			resultado.append("(");
			String separador = "";

			if (izquierda != null) {
				resultado.append(separador).append(izquierda.toString());			
				separador = ",";
			}
			
			if (derecha != null) {
				resultado.append(separador).append(derecha.toString());
			}

			resultado.append(")");

			return resultado.toString();
		}
		
		public String toStringOrdenado() {
			StringBuilder resultado = new StringBuilder();
			String separador = "";
			

			if (izquierda == null && derecha == null) {
				resultado.append(id);
				return resultado.toString();
			}
			
			if (izquierda != null) {
				resultado.append(separador).append(izquierda.toStringOrdenado());	
				separador = " ";
			}
			
			resultado.append(separador).append(id);
			separador = " ";

			if (derecha != null) {
				resultado.append(separador).append(derecha.toStringOrdenado());
			}

			return resultado.toString();
		}

		public void insertarHijo(Nodo<E> nuevoNodo) throws Exception {
			if (izquierda == null)
				izquierda = nuevoNodo;
			else if (derecha == null)
				derecha = nuevoNodo;
			else
				throw new Exception("Trata de colocar nuevo nodo " + nuevoNodo.getId() + " debajo de " + this.id + ", pero " + this.toString() + " no puede tener mas de dos hijos");
		}

		public void insertarOrdenado(E o, String id) {
			if (((Comparable)o).compareTo(contenido) < 0) {
				if (izquierda == null) {
					izquierda = new Nodo(id, o);
					return;
				}
				else {
					izquierda.insertarOrdenado(o, id);
				}
			} else {
				if (derecha == null) {
					derecha = new Nodo(id, o);
					return;
				}
				else {
					derecha.insertarOrdenado(o, id);
				}
			}
		}
	}

	private Nodo<E> raiz;

	public ArbolBinario() {
		raiz = null;
	}
	
	public void insertar(E o, String id) throws Exception {
		
		if (raiz == null || !(o instanceof Comparable))
		{
			// log.warning("El nodo se inserta pero reemplaza a la raiz ya que no tiene padre")
			insertar(o, id, null);
			return;
		}
		
		raiz.insertarOrdenado(o, id);
	}

	public void insertar(E o, String id, String idpadre) throws Exception {
		if (idpadre == null) {
			raiz = new Nodo<E>(id, o);
			return;
		}

		// Primero tenemos que encontrar el padre
		Nodo<E> padre = encontrar(idpadre);

		// Crear el nuevo nodo y colocarlo como hijo del padre encontrado
		Nodo<E> nuevoNodo = new Nodo<E>(id, o);
		padre.insertarHijo(nuevoNodo);
		nuevoNodo.setPadre(padre);
	}

	private Nodo<E> encontrar(String padre) {
		return raiz.encontrar(padre);
	}
	
	public String toStringOrdenado() {
		if (raiz == null)
			return "[VACIO]";
				
		return raiz.toStringOrdenado();
	}

	@Override
	public String toString() {
		if (raiz == null)
			return "[VACIO]";
				
		return raiz.toString();
	}
}
