package recursividad.hanoi.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import recursividad.hanoi.Anillo;
import recursividad.hanoi.Hanoi;
import recursividad.hanoi.Torre;

public class DibujoHanoiBonito implements IDibujo {

	private Hanoi modelo;

	public DibujoHanoiBonito(Hanoi modelo) {
		this.modelo = modelo;
	}

	public void dibujar(Graphics g) {
		dibujarBase(g);
	}

	private void dibujarTorre(Graphics g, int nroTorre, int x, int y) {
		g.setColor(Color.green);
		g.fillRect(x, y - 250, 15, 250);
		
		Torre torre = modelo.getTorre(nroTorre);
		
		int yAnillo = y;
		for (Iterator<Anillo> iterator = torre.getAnillos().iterator(); iterator.hasNext();) {
			
			yAnillo -= 20;
			
			Anillo anillo = iterator.next();
			
			dibujarAnillo(g, anillo, x, yAnillo);
		}
	}
	
	private void dibujarAnillo(Graphics g, Anillo anillo, int x, int yAnillo) {
		int xAnillo = x - anillo.getTamano() * 10;
		g.setColor(Color.cyan);
		g.fillRect(xAnillo, yAnillo, anillo.getTamano() * 10 * 2 + 15, 10);
	}

	private void dibujarBase(Graphics g) {
		g.fillRect(50, 350, 500, 20);
		
		dibujarTorre(g,0, 150, 350);
		dibujarTorre(g,1, 300, 350);
		dibujarTorre(g,2, 450, 350);
	}	
}
