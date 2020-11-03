package tests.unidad4;

import arboles.ArbolBinario;

public class TestArbolBinarioOrdenado {
	public static void main(String[] args) {
		ArbolBinario<Integer> arbol = new ArbolBinario<Integer>();

		System.out.println(arbol);

		try {
			arbol.insertar(8, "8");
			arbol.insertar(10, "10");
			arbol.insertar(20, "20");

			arbol.insertar(12, "12");
			arbol.insertar(18, "18");
			arbol.insertar(6, "6");

		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}

		System.out.println(arbol);
		System.out.println(arbol.toStringOrdenado());
	}
}
