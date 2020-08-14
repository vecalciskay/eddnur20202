package recursividad;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HanoiBasico {
	private static final Logger logger = LogManager.getRootLogger();
	private int numAnillos;

	public HanoiBasico(int n) {
		this.numAnillos = n;
	}

	public void resolver(int de, int a, int pp) {
		h(de, a, pp, numAnillos);
	}

	public void h(int de, int a, int pp, int n) {
		logger.debug("Entrando a llamar a H(" + de + ", "+ a + ", "+ pp + ", "+ n + ")");
		if (n == 1) {
			System.out.println(de + " -> " + a);
			return;
		}
		
		h(de, pp, a, n - 1);
		h(de, a, pp, 1);
		h(pp, a, de, n - 1);
	}

}
