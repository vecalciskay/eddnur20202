package recursividad.hanoi.gui;

import java.awt.Graphics;
import java.util.Iterator;

import recursividad.hanoi.Anillo;
import recursividad.hanoi.Hanoi;
import recursividad.hanoi.Torre;

public class DibujoHanoi implements IDibujo{

	public static final int ANCHO_ANILLO = 10;
	public static final int ANCHO_TORRE = 15;
	public static final int ALTURA_TORRE = 250;
	public static final int ANCHO_BASE = 500;
	public static final int ALTURA_BASE = 20;
	public static final int ESPACIO_ANILLO = 20;
	
	
	private Hanoi modelo;

	public DibujoHanoi(Hanoi modelo) {
		this.modelo = modelo;
	}

	public void dibujar(Graphics g) {
		dibujarBase(g);
	}

	private void dibujarTorre(Graphics g, int nroTorre, int x, int y) {
		g.fillRect(x, y - ALTURA_TORRE, ANCHO_TORRE, ALTURA_TORRE);
		
		Torre torre = modelo.getTorre(nroTorre);
		
		int yAnillo = y;
		for (Iterator<Anillo> iterator = torre.getAnillos().iterator(); iterator.hasNext();) {
			
			yAnillo -= ESPACIO_ANILLO;
			
			Anillo anillo = iterator.next();
			
			dibujarAnillo(g, anillo, x, yAnillo);
		}
	}
	
	private void dibujarAnillo(Graphics g, Anillo anillo, int x, int yAnillo) {
		int xAnillo = x - anillo.getTamano() * ANCHO_ANILLO;
		g.fillRect(xAnillo, yAnillo, 
				anillo.getTamano() * ANCHO_ANILLO * 2 + ANCHO_TORRE, ANCHO_ANILLO);
	}

	private void dibujarBase(Graphics g) {
		int y = 350;
		g.fillRect(50, y, ANCHO_BASE, ALTURA_BASE);
		
		dibujarTorre(g,0, 150, y);
		dibujarTorre(g,1, 300, y);
		dibujarTorre(g,2, 450, y);
	}	
}
