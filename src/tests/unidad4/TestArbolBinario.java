package tests.unidad4;

import arboles.ArbolBinario;

public class TestArbolBinario {
	public static void main(String[] args) {
		ArbolBinario<String> arbol = new ArbolBinario<String>();
		
		System.out.println(arbol);
		
		try {
			arbol.insertar("M", "M", null);
			arbol.insertar("A", "A", "M");
			arbol.insertar("C", "C", "M");		
			
			arbol.insertar("D", "D", "C");
			arbol.insertar("H", "H", "C");
			arbol.insertar("X", "X", "C");
			
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		

		System.out.println(arbol);
		
	}
}
