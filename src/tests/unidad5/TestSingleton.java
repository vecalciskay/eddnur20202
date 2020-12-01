package tests.unidad5;

import dao.Conexion;

public class TestSingleton {
	public static void main(String[] args) {

//		Conexion c1 = new Conexion();
//		Conexion c2 = new Conexion();
//		
//		if (c1 == c2) {
//			System.out.println("c1 y c2 son IGUALES");
//		}
//		else {
//			System.out.println("c1 y c2 son DIFERENTES");
//		}
//		
//		Conexion.singleton = new Conexion();
//		
//		c1 = Conexion.getSingleton();
//		c2 = Conexion.getSingleton();
//		
//		if (c1 == c2) {
//			System.out.println("c1 y c2 son IGUALES");
//		}
//		else {
//			System.out.println("c1 y c2 son DIFERENTES");
//		}
		
		/*
		 * c1 y c2 son DIFERENTES
		 * c1 y c2 son IGUALES
		 */
		
		
		Conexion c1 = Conexion.getSingleton();
		Conexion c2 = Conexion.getSingleton();
		
		if (c1 == c2) {
			System.out.println("c1 y c2 son IGUALES");
		}
		else {
			System.out.println("c1 y c2 son DIFERENTES");
		}
		
		
	}
}
