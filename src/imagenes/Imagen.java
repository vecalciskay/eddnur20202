package imagenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Imagen {

	private int ancho;
	private int alto;
	private int[][] pixeles;
	
	public Imagen(int w, int h) {
		ancho = w;
		alto = h;
		pixeles = new int[ancho][alto];
	}
	
	public void inicializar() {
		for(int j=100; j<110; j++) {
			for(int i=0; i<ancho; i++) {
				pixeles[i][j] = 0x00ff0000; // rojo
			}
		}
	}

	public void addObservador(PanelImagen pnlJPanel) {
		// 
	}

	public void dibujar(Graphics g) {
		BufferedImage rsm = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = rsm.createGraphics();
		
		for (int i = 0; i < ancho; i++) {
			for (int j = 0; j < alto; j++) {
				g2d.setColor(new Color(pixeles[i][j]));
				g2d.drawLine(i, j, i, j);
			}
		}
		
		g.drawImage(rsm, 0, 0, null);
	}

	public void crearCuadrado(int x, int y) {
		for (int i = x; i < (x+10); i++) {
			for (int j = y; j < (y+10); j++) {
		pixeles[i][j] = 0x00EDE43A;
			}
		}
	}

}
