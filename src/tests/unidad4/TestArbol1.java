package tests.unidad4;

import arboles.Arbol;

public class TestArbol1 {
	public static void main(String[] args) {
		Arbol<String> arbol = new Arbol<String>();
		
		System.out.println(arbol);
		
		arbol.insertar("M", "M", null);
		arbol.insertar("A", "A", "M");
		arbol.insertar("C", "C", "M");
		
		System.out.println(arbol);
		
		arbol.insertar("X", "X", null);
		
		arbol.insertar("M", "M", "X");
		arbol.insertar("A", "A", "X");
		arbol.insertar("C", "C", "X");
		
		arbol.insertar("D", "D", "M");
		arbol.insertar("H", "H", "A");
		arbol.insertar("L", "L", "A");
		
		System.out.println(arbol);
		
	}
}
