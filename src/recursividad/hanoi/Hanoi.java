package recursividad.hanoi;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tests.unidad1.TestHanoi;

public class Hanoi {

	private static final Logger logger = LogManager.getRootLogger();
	private Torre[] torres;
	private PropertyChangeSupport cambios;
	private int milisegundos;
	
	public Hanoi() {
		torres = new Torre[3];
		torres[0] = new Torre();
		torres[1] = new Torre();
		torres[2] = new Torre();
		cambios = new PropertyChangeSupport(this);
	}
	
	/**
	 * Crear numeroAnillos Anillos de tamaños diferentes.<br/>
	 * Y meter esos anillos en orden a la torre correspondiente
	 * 
	 * @param numeroAnillos un numero positivo de anillos
	 * @param torre El numero de la torre que corresponde (0, 1 o 2)
	 * @throws Exception 
	 */
	public void inicial(int numeroAnillos, int torre) throws Exception {
		if (numeroAnillos <= 0)
			throw new Exception("Se necesita un numero positivo de anillos");
		
		if (torre < 0 ||  torre > 2)
			throw new Exception("La torre solamente puede ser 0, 1 o 2");
		
		for (int i = numeroAnillos; i > 0; i--) {
			Anillo anillo = new Anillo(i);
			torres[torre].meter(anillo);
		}
	}
	
	@Override
	public String toString() {
		
		StringBuilder resultado = new StringBuilder();
		resultado.append(torres[0].toString()).append("\n");
		resultado.append(torres[1].toString()).append("\n");
		resultado.append(torres[2].toString());
		
		return resultado.toString();
	}
	
	public void resolver(int de, int a, int pp)  {
		resolver(de, a, pp, 0);
	}
	
	public void resolver(int de, int a, int pp, int milisegundos)  {
		this.milisegundos = milisegundos;
		resolverRecursivo(de,a,pp,torres[de].cantidad());
	}

	private void resolverRecursivo(int de, int a, int pp, int n) {
		logger.debug("Entrando a llamar a H(" + de + ", "+ a + ", "+ pp + ", "+ n + ")");
		if (n == 1) {
			Anillo anillo = torres[de].sacar();
			torres[a].meter(anillo);
			cambios.firePropertyChange("MUEVE", de, a);
			try {
				Thread.sleep(milisegundos);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return;
		}
		
		resolverRecursivo(de, pp, a, n - 1);
		resolverRecursivo(de, a, pp, 1);
		resolverRecursivo(pp, a, de, n - 1);
	}

	public void addObservador(PropertyChangeListener observadorHanoi) {
		cambios.addPropertyChangeListener(observadorHanoi);
	}

	public Torre getTorre(int nroTorre) {
		return torres[nroTorre];
	}
}
