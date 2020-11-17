package tests.unidad4;

import arboles.ArbolAritmetico;
import arboles.ArbolBinario;
import arboles.Numero;
import arboles.Operacion;
import arboles.Operador;

public class TestArbolAritmetico {
	public static void main(String[] args) {
		ArbolAritmetico arbol = new ArbolAritmetico();

		System.out.println(arbol);

		try {
			arbol.insertar(new Operacion(Operador.suma), "1", null);
			arbol.insertar(new Operacion(Operador.resta), "2", "1");
			arbol.insertar(new Operacion(Operador.suma), "3", "1");

			arbol.insertar(new Numero(7.0), "4", "2");
			arbol.insertar(new Numero(3.0), "5", "2");

			arbol.insertar(new Numero(5.0), "6", "3");
			arbol.insertar(new Numero(2.0), "7", "3");

		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}

		System.out.println(arbol);
	}
}
