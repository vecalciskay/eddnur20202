package recursividad;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClaseMetodosRecursivos {
	private static final Logger logger = LogManager.getRootLogger();
	private int[] fibos;

	public ClaseMetodosRecursivos() {
		fibos = new int[10000000];
		for (int i = 0; i < fibos.length; i++) {
			fibos[i] = -1;
		}
	}

	/**
	 * Serie: 0 1 1 2 3 5 8 13 21 n : 1 2 3 4 5 6 7 8 9
	 * 
	 * @param n
	 * @return
	 */
	public int fibo(int n) {
		if (fibos[n] != -1) {
			// ya esta calculado
			return fibos[n];
		}

		logger.debug("--- calculando fibo " + n + " ---");

		if (n == 1) {
			fibos[1] = 0;
			return 0;
		}
		if (n == 2) {
			fibos[2] = 1;
			return 1;
		}
		int calculado = fibo(n - 1) + fibo(n - 2);
		fibos[n] = calculado;
		return calculado;
	}

	public void recursivoTonto() {
		System.out.println("Hola");
		recursivoTonto();
	}

	public void recursivoTonto2(int n) throws Exception {
		if (n < 1)
			throw new Exception("No puede n ser menor a 1");
		System.out.println("Hola");
		if (n == 1)
			return;

		recursivoTonto2(n - 1);
	}

	public int suma(int n) {
		if (n == 0)
			return 0;

		return suma(n - 1) + n;
	}

}
