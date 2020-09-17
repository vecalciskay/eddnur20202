package imagenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeSupport;

import imagenes.operaciones.Mandelbrot;
import imagenes.operaciones.NumeroComplejo;

public class Imagen {

	private int ancho;
	private int alto;
	/**
	 * El formato del pixel es RGB
	 */
	private int[][] pixeles;
	private PropertyChangeSupport observado;
	private Mandelbrot procesoMandelbrot;

	public Imagen(int w, int h) {
		ancho = w;
		alto = h;
		pixeles = new int[ancho][alto];
		observado = new PropertyChangeSupport(this);
		procesoMandelbrot = new Mandelbrot(this);
	}

	public void inicializar() {
		for (int j = 100; j < 110; j++) {
			for (int i = 0; i < ancho; i++) {
				pixeles[i][j] = 0x00ff0000; // rojo
			}
		}
	}

	public void addObservador(PanelImagen pnlJPanel) {
		observado.addPropertyChangeListener(pnlJPanel);
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
		for (int i = x; i < (x + 10); i++) {
			for (int j = y; j < (y + 10); j++) {
				pixeles[i][j] = 0x00EDE43A;
			}
		}
		observado.firePropertyChange("cuadrado", false, true);
	}

	public void setImagen(BufferedImage img) {
		ancho = img.getWidth();
		alto = img.getHeight();
		pixeles = new int[ancho][alto];
		
		for (int i = 0; i < ancho; i++) {
			for (int j = 0; j < alto; j++) {
				pixeles[i][j] = img.getRGB(i, j);
			}
		}
		
		observado.firePropertyChange("imagen", false, true);
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getPixel(int x, int y) {
		return pixeles[x][y];
	}
	
	public void setPixel(int c, int x, int y) {
		pixeles[x][y] = c;
	}
	
	public int[][] getHistograma() {
		int[][] histo = new int[3][256];
		
		// for
		// for
		// histo[rojo][colorR] = histo[rojo][colorR]+1;
		
		return histo;
	}

	protected void mandelbrot(int w, int h) {
		ancho = w;
		alto = h;
		pixeles=new int[w][h];
		
		
		procesoMandelbrot.hacer();
		
		observado.firePropertyChange("Imagen", false, true);
	}

	public void zoomMandelbrot(int x, int y) {
		NumeroComplejo c = procesoMandelbrot.getComplejoParaPuntoXY(x, y);
		procesoMandelbrot.setPlanoComplejo(c.getReal() - 0.15, c.getImag() - 0.1,
				c.getReal() + 0.1, c.getImag() + 0.1);
		
		procesoMandelbrot.hacer();
		observado.firePropertyChange("Imagen", false, true);
	}

}
