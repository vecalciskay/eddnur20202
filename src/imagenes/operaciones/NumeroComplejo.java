package imagenes.operaciones;

public class NumeroComplejo {

	private double real;
	private double imag;
	
	public NumeroComplejo(double r, double i) {
		real = r;
		imag = i;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}

	public double modulo() {
		return Math.sqrt(real*real + imag*imag);
	}

	public NumeroComplejo cuadrado() {
		//   (x1 + y1i)(x1 + y1i)
		// = x1^2 + 2x1y1i - y1^2
		// = x1^2-y1^2 + 2x1y1i
		double r = real * real - imag * imag;
		double i = 2.0 * real * imag;
		return new NumeroComplejo(r,i);
	}

	public NumeroComplejo sumar(NumeroComplejo otro) {
		return new NumeroComplejo(real + otro.getReal(), imag + otro.getImag());
	}
	
	
}
