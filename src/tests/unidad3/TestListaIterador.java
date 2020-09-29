package tests.unidad3;

import java.util.Iterator;

import listas.Lista;

public class TestListaIterador {
	public static void main(String[] args) {
		Lista<String> a = new Lista<String>();
		System.out.println(a);

		a.insertar("Hugo");
		a.insertar("Paco");
		a.insertar("Luis");
		a.insertar("Maria");
		a.insertar("Cecilia");
		a.insertar("Lucia");
		a.insertar("Fernando");
		a.insertar("Marco");

		System.out.println(a);

		// Contando operaciones:
		// tamano: 8 op
		// get(0): 1
		// get(1): 2
		// get(2): 3
		// ..
		// get(7): 8
		// al final, el for tiene:  44 ops
		int total = a.tamano();
		for(int i=0; i<total; i++) {
			System.out.println("Elemento pos: " + i + " es " + a.get(i));
		}
		
		System.out.println(" ------------------------------------------------------ ");
		
		int i = 0;
		for (String s : a) {
			System.out.println("Elemento pos: " + i + " es " + s);
			i++;
		}
	}
}
