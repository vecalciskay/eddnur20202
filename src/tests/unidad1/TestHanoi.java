package tests.unidad1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import recursividad.hanoi.Hanoi;

public class TestHanoi implements PropertyChangeListener {
	
	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
		TestHanoi observadorHanoi = new TestHanoi();
		
		hanoi.addObservador(observadorHanoi);
		
		try {
			hanoi.inicial(3, 0);
		} catch (Exception e) {
			System.out.println("Puso algo mal: " + e.getMessage());
		}
		
		System.out.println(hanoi);
		
		hanoi.resolver(0, 2, 1);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Hanoi h = (Hanoi)evt.getSource();
		System.out.println(h);
	}
}
