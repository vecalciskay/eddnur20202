package tests.unidad4;

import arboles.ArbolAritmetico;

public class TestLectorArbolAritmetico {
	public static void main(String[] args) throws Exception {
		
		String expresion = "4"; 
		ArbolAritmetico arbol = new ArbolAritmetico(expresion);
		System.out.println(arbol);
		
		expresion = " (  46)"; 
		arbol = new ArbolAritmetico(expresion);
		System.out.println(arbol);
		
		expresion = "445734"; 
		arbol = new ArbolAritmetico(expresion);
		System.out.println(arbol);
		
		expresion = "4 +                   5"; 
		arbol = new ArbolAritmetico(expresion);
		System.out.println(arbol);
		
		expresion = "(  3.5+  7)   -  8"; 
		arbol = new ArbolAritmetico(expresion);
		System.out.println(arbol);
		
		expresion = "( (4*2)/(6+(	3-1.856)) ) +5"; 
		arbol = new ArbolAritmetico(expresion);
		System.out.println(arbol);
	}
}
