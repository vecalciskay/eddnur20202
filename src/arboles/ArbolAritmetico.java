package arboles;

public class ArbolAritmetico {
	class Nodo {
		private String id;
		private Nodo izquierda;
		private Nodo derecha;
		private ObjetoAritmetico contenido;
		private Nodo padre;

		public Nodo(String nuevoId, ObjetoAritmetico c) {
			contenido = c;
			padre = null;
			id = nuevoId;
			izquierda = null;
			derecha = null;
		}

		public Nodo getIzquierda() {
			return izquierda;
		}

		public void setIzquierda(Nodo izquierda) {
			this.izquierda = izquierda;
		}

		public Nodo getDerecha() {
			return derecha;
		}

		public void setDerecha(Nodo derecha) {
			this.derecha = derecha;
		}

		public String getId() {
			return id;
		}

		public ObjetoAritmetico getContenido() {
			return contenido;
		}

		public Nodo getPadre() {
			return padre;
		}

		public void setPadre(Nodo padre) {
			this.padre = padre;
		}

		public Nodo encontrar(String idpadre) {
			if (this.id.equals(idpadre))
				return this;

			Nodo encontro = null;
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

			// Si es numero devuelve el numero
			if (contenido instanceof Numero)
				return contenido.toString();
			
			resultado.append("(");
			if (izquierda != null)
				resultado.append(izquierda.toString());
			
			resultado.append(contenido.toString());

			if (derecha != null)
				resultado.append(derecha.toString());

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

		public void insertarHijo(Nodo nuevoNodo) throws Exception {
			if (izquierda == null)
				izquierda = nuevoNodo;
			else if (derecha == null)
				derecha = nuevoNodo;
			else
				throw new Exception("Trata de colocar nuevo nodo " + nuevoNodo.getId() + " debajo de " + this.id + ", pero " + this.toString() + " no puede tener mas de dos hijos");
		}

		public void insertarOrdenado(ObjetoAritmetico o, String id) {
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
		
		public double evaluar() {
			if (contenido instanceof Numero) {
				return ((Numero) contenido).evaluar();
			}
			
			double izq = izquierda == null ? 0.0 : izquierda.evaluar();
			double der = derecha == null ? 0.0 : derecha.evaluar();
			
			return ((Operacion)contenido).evaluar(izq, der);
		}
	}

	private Nodo raiz;

	public ArbolAritmetico() {
		raiz = null;
	}
	
	public ArbolAritmetico(String expresion) throws Exception {
		raiz = leerExpresion(null, expresion);
	}
	
	private Nodo leerExpresion(Nodo padre, String expresion) throws Exception {
		int largo = expresion.length();

		int posicionActual = 0;
		int conteoParentesis = 0;
		
		int posibleNumeroExpresion = Integer.MIN_VALUE;
		try {
			posibleNumeroExpresion = Integer.parseInt(expresion);
			Nodo resultadoNodo = new Nodo("A", new Numero((double)posibleNumeroExpresion));
			resultadoNodo.setPadre(padre);
			return resultadoNodo;
		} catch (Exception e) {
			// Nada
		}
		
		while(posicionActual < largo) {
			int numero = Integer.MIN_VALUE;
			try {
				numero = Integer.parseInt(String.valueOf(expresion.charAt(posicionActual)));
				
				// posible numero
				posicionActual++;
				continue;
			}
			catch(Exception q) {
				numero = Integer.MIN_VALUE;
			}
			
			if (expresion.charAt(posicionActual) == '(') {
				conteoParentesis++;
				posicionActual++;
				continue;
			}
			
			if (expresion.charAt(posicionActual) == ')') {
				conteoParentesis--;
				posicionActual++;
				continue;
			}
			
			Operador posibleOperadorPrincipal = null;
			try {
				posibleOperadorPrincipal = 
						Operacion.ParseOperador(String.valueOf(expresion.charAt(posicionActual)));
				if (conteoParentesis == 0) {
					
					// 0.  Crear el NODO
					Nodo resultadoNodo = new Nodo("A", new Operacion(posibleOperadorPrincipal));
					resultadoNodo.setPadre(padre);
					
					// 1. Crear el NODO IZQUIERDA
					String izquierdaExpresion = expresion.substring(0, posicionActual);
					Nodo izquierdaNodo = leerExpresion(resultadoNodo, izquierdaExpresion);
					resultadoNodo.setIzquierda(izquierdaNodo);

					// 2. Crear el NODO DERECHA
					String derechaExpresion = expresion.substring(posicionActual+1);
					Nodo derechaNodo = leerExpresion(resultadoNodo, derechaExpresion);
					resultadoNodo.setDerecha(derechaNodo);
					
					return resultadoNodo;
					
				}
			} catch(Exception q) {
				posicionActual++;
				continue;
			}
		}
		
		throw new Exception("No pudo leer la expresion");
	}

	public void insertar(ObjetoAritmetico o, String id) throws Exception {
		
		if (raiz == null || !(o instanceof Comparable))
		{
			// log.warning("El nodo se inserta pero reemplaza a la raiz ya que no tiene padre")
			insertar(o, id, null);
			return;
		}
		
		raiz.insertarOrdenado(o, id);
	}

	public void insertar(ObjetoAritmetico o, String id, String idpadre) throws Exception {
		if (idpadre == null) {
			raiz = new Nodo(id, o);
			return;
		}

		// Primero tenemos que encontrar el padre
		Nodo padre = encontrar(idpadre);

		// Crear el nuevo nodo y colocarlo como hijo del padre encontrado
		Nodo nuevoNodo = new Nodo(id, o);
		padre.insertarHijo(nuevoNodo);
		nuevoNodo.setPadre(padre);
	}

	private Nodo encontrar(String padre) {
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
				
		String expresionAritmetica = raiz.toString();
		double resultado = evaluar();
		return expresionAritmetica + " = " + resultado;
	}
	
	public double evaluar() {
		return raiz.evaluar();
	}
}
