package arboles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import listas.Lista;

public class Arbol<E> {

	class Nodo<E> {
		private String id;
		private Lista<Nodo<E>> hijos;
		private E contenido;
		private Nodo<E> padre;
		
		public final int ANCHO_NODO = 40;
		public final int ESPACIO_HORIZONTAL_NODO = 20;
		public final int ESPACIO_VERTICAL_NODO = 30;

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
		
		public void dibujar(Graphics g, int x, int y) {
			if (this.hijos.tamano() == 0) {
				dibujarNodoSolamente(g, x, y);
				return;
			}
			
			int anchoTotal = getAncho();
			
			int mitadNodoX = x + anchoTotal / 2;
			int mitadNodoY = y + ANCHO_NODO / 2;
			
			int yHijo = y + ANCHO_NODO + ESPACIO_VERTICAL_NODO;
			int xHijo = x;
			int espacioEntreHijos = 0;
			
			for (Nodo<E> nodo : hijos) {
				
				int anchoHijo = nodo.getAncho();
				g.drawLine(mitadNodoX, mitadNodoY, 
						xHijo + anchoHijo / 2, yHijo + ANCHO_NODO / 2);
				
				nodo.dibujar(g, xHijo, yHijo);	
				
				espacioEntreHijos = ESPACIO_HORIZONTAL_NODO;
				xHijo = xHijo + anchoHijo + espacioEntreHijos;
			}
			
			dibujarNodoSolamente(g, 
					x + anchoTotal / 2 - ANCHO_NODO / 2, 
					y);
		}
		
		public void dibujarNodoSolamente(Graphics g, int x, int y) {
			g.setColor(Color.white);
			g.fillOval(x, y, ANCHO_NODO, ANCHO_NODO);
			g.setColor(Color.black);
			g.drawOval(x, y, ANCHO_NODO, ANCHO_NODO);
			int mitadAnchoNodo = ANCHO_NODO / 2;
			g.drawString(id, x + mitadAnchoNodo - 5, y + mitadAnchoNodo + 5);
		}

		private int getAncho() {
			if (this.hijos.tamano() == 0) {
				return ANCHO_NODO;
			}
			
			int espacioEntreNodos = 0;
			int anchoTotal = 0;
			for (Nodo<E> nodo : hijos) {
				anchoTotal += (espacioEntreNodos + nodo.getAncho());
				espacioEntreNodos = ESPACIO_HORIZONTAL_NODO;
			}
			
			return anchoTotal;
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
	
	public void dibujar(Graphics g, int x, int y) {

		if (raiz == null)
			g.drawString("ARBOL VACIO!!", x, y);
		else
			raiz.dibujar(g, x, y);		
	}
}
