package strategy.bien;

public class PatoMadera extends Pato {
	
	public PatoMadera() {
		nombre = "Pato de madera";
		estrategiaVolar = new NoVuela(this);
		estrategiaHablar = new NoHabla(this);
	}
}
