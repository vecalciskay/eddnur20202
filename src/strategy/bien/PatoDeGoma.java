package strategy.bien;

public class PatoDeGoma extends Pato {

	public PatoDeGoma() {
		nombre = "Pato de goma";
		estrategiaVolar = new NoVuela(this);
		estrategiaHablar = new Skuiiiik(this);
	}

}
