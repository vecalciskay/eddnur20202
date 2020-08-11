package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import recursividad.ClaseMetodosRecursivos;

public class TestRecursivoTonto {

	private static final Logger logger = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		ClaseMetodosRecursivos c = new ClaseMetodosRecursivos();
		try {
			logger.debug("Ejecutando el recursivoTonto con n 10");
			c.recursivoTonto2(10);
		} catch (Exception e) {
			logger.error("Hubo un error", e);
		}
		
		
		int s = c.suma(4);
		System.out.println("Suma: " + s);
		
		int fparam = 9;
		int f = c.fibo(fparam);
		System.out.println("Fibo(" + fparam + "): " + f);
	}
}
