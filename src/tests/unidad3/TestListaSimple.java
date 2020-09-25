package tests.unidad3;


import listas.ListaSimple;

public class TestListaSimple {
	public static void main(String[] args) {
		ListaSimple a = new ListaSimple();
		System.out.println(a);
		
		a.insertar("Hugo");
		a.insertar("Paco");
		a.insertar("Luis");
		
		System.out.println(a);
	}
}
