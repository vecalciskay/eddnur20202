package strategy.bien;

public class PatoSalvaje extends Pato {
	
	public PatoSalvaje() {
		nombre = "Pato salvaje";
		estrategiaHablar = new Cuac(this);
		estrategiaVolar = new Vuela(this);
	}

}
