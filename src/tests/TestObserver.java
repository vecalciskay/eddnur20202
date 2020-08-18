package tests;

import observer.Alumno;
import observer.Profesor;

public class TestObserver {
	public static void main(String[] args) {
		Alumno a1 = new Alumno("hugo");
		Alumno a2 = new Alumno("paco");
		Alumno a3 = new Alumno("luis");
		Profesor p1 = new Profesor("Donald");
		
		// Crear la dependencia uno a muchos de observer
		p1.addObservador(a1);
		p1.addObservador(a2);
		p1.addObservador(a3);
		
		a1.comienzaExamen();
		a2.comienzaExamen();
		a3.comienzaExamen();
		p1.saleCurso();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p1.llegaCurso();
	}
}
