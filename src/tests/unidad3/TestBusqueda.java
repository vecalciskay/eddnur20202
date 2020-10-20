package tests.unidad3;

import listas.ListaOrdenada;
import listas.model.Persona;

public class TestBusqueda {
	public static void main(String[] args) {
		ListaOrdenada<Persona> a = new ListaOrdenada<Persona>();
		System.out.println(a);

		a.insertar(new Persona("Hugo", 65162786));
		a.insertar(new Persona("Paco", 32445646));
		a.insertar(new Persona("Luis", 8864565));
		a.insertar(new Persona("Maria", 9257656));
		a.insertar(new Persona("Cecilia", 6047903));
		a.insertar(new Persona("Lucia", 2364673));
		a.insertar(new Persona("Fernando", 15738345));
		a.insertar(new Persona("Marco", 5009854));
		
		System.out.println(a);
		
		Persona persona = new Persona("", Long.valueOf(2364673));
		Persona encontrada = a.buscarSimple(persona);
		
		System.out.println(encontrada);
	}
}
