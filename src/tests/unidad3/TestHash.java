package tests.unidad3;

import hash.FuncionHash;

public class TestHash {
	public static void main(String[] args) {
		String str = "perro";
		FuncionHash h = new FuncionHash();
		System.out.println(str + " = " + h.hash(str));

		String[] arreglo = new String[1000];

		String[] a = { "perro", "gato", "vaca", "loro", "mono", "jirafa" };
		for (String s : a)
			arreglo[(int) h.hash(s)] = s;
		
		for (int i = 0; i < arreglo.length; i++) {
			if (arreglo[i] != null)
				System.out.println(arreglo[i]);
		}
		
		// Buscar vaca
		String encontrado = arreglo[(int)h.hash("loro")];
		System.out.println(encontrado);
	}
}
