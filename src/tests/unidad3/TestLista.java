package tests.unidad3;

import java.util.Iterator;

import listas.Lista;

public class TestLista {
	public static void main(String[] args) {
		Lista<String> a = new Lista<String>();
		System.out.println(a);

		a.insertar("Hugo");
		a.insertar("Paco");
		a.insertar("Luis");

		System.out.println(a);
		
		System.out.println(a.get(2));
		
		System.out.println("For abreviado");
		for(String s : a) {
			System.out.println(s);
		}
		
		System.out.println("El tamano de la lista es: " + a.tamano());		
		
		a.vaciar();
		
		a.adicionar("Hugo");
		a.adicionar("Paco");
		a.adicionar("Luis");
		a.insertar("Soledad");
		
		System.out.println(a);
		
		a.eliminar(2);

		System.out.println(a);
		
		a.insertar(2, "Juan");

		System.out.println(a);
	}
}
