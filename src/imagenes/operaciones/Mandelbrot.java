package imagenes.operaciones;

import imagenes.Imagen;

public class Mandelbrot {

	private Imagen imagen;
	private double maxX = 1;
	private double minX = -1.5;
	private double maxY = 1;
	private double minY = -1;

	public Mandelbrot(Imagen img) {
		this.imagen = img;
	}
	
	public void setPlanoComplejo(double r1, double i1, double r2, double i2) {
		minX = r1;
		maxX = r2;
		minY = i1;
		maxY = i2;
	}
	

	public void hacer() {

		for (int i = 0; i < imagen.getAncho(); i++) {
			for (int j = 0; j < imagen.getAlto(); j++) {
				int n = mandelbrotPixel(i,j);
				int color = colorearNumero(n);
			    imagen.setPixel(color, i, j);
			}
		}
	}

	private int colorearNumero(int n) {
		int rojo = n << 16;
		int verde = n << 8;
		return rojo | verde | n;
	}

	private int mandelbrotPixel(int i, int j) {
		
		NumeroComplejo inicial = getComplejoParaPuntoXY(i,j);
		NumeroComplejo actual = new NumeroComplejo(inicial.getReal(), inicial.getImag());
		int n = 0;
		while(n <= 255 && actual.modulo() < 2.0) {
			actual = actual.cuadrado().sumar(inicial);
			n++;
		}
		return n;
	}

	public NumeroComplejo getComplejoParaPuntoXY(int i, int j) {
		
		double real = minX + ((double)i * (maxX - minX) / (double)imagen.getAncho());
		double imag = minY + ((double)j * (maxY - minY) / (double)imagen.getAlto());
		return new NumeroComplejo(real, imag);
	}
}
