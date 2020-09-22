package strategy.bien;

public class PatoGranja extends Pato {

	public PatoGranja() {
		nombre = "Pato de granja";
		estrategiaVolar = new Vuela(this);
		estrategiaHablar = new Cuac(this);
	}
}
