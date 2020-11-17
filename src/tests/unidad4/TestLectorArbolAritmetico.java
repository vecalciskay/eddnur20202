package tests.unidad4;

import arboles.ArbolAritmetico;

public class TestLectorArbolAritmetico {
	public static void main(String[] args) throws Exception {
		
		String expresion = "4"; 
		ArbolAritmetico arbol = new ArbolAritmetico(expresion);
		System.out.println(arbol);
		
		expresion = "46"; 
		arbol = new ArbolAritmetico(expresion);
		System.out.println(arbol);
		
		expresion = "445734"; 
		arbol = new ArbolAritmetico(expresion);
		System.out.println(arbol);
		
		expresion = "4+5"; 
		arbol = new ArbolAritmetico(expresion);
		System.out.println(arbol);
		
		expresion = "3+7"; 
		arbol = new ArbolAritmetico(expresion);
		System.out.println(arbol);
		
	}
}
