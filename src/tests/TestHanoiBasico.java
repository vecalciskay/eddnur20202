package tests;

import recursividad.HanoiBasico;

public class TestHanoiBasico {
	public static void main(String[] args) {
		HanoiBasico objBasico = new HanoiBasico(3);
		objBasico.resolver(1, 3, 2);
	}
}
