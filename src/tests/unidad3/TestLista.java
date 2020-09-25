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
		
		Iterator<String> iterator = a.iterator();
		while(iterator.hasNext()) {
			String persona = iterator.next();
			System.out.println(persona);
		}
		
		System.out.println("For abreviado");
		for(String s : a) {
			System.out.println(s);
		}
		
		System.out.println("El tamano de la lista es: " + a.tamano());
	}
}
