package tests.patrones;

public class TestStrategy {
	public static void main(String[] args) {
		
		System.out.println("Mala implementacion");
		
		strategy.mal.Pato p1 = new strategy.mal.PatoDeGoma();
		strategy.mal.Pato p2 = new strategy.mal.PatoGranja();
		strategy.mal.Pato p3 = new strategy.mal.PatoMadera();

		p1.volar();
		p1.hablar();

		p2.volar();
		p2.hablar();

		p3.volar();
		p3.hablar();
		
		
		System.out.println("Buena implementacion");
		
		strategy.bien.Pato p4 = new strategy.bien.PatoDeGoma();
		strategy.bien.Pato p5 = new strategy.bien.PatoGranja();
		strategy.bien.Pato p6 = new strategy.bien.PatoMadera();

		p4.volar();
		p4.hablar();

		p5.volar();
		p5.hablar();

		p6.volar();
		p6.hablar();

	}
}
