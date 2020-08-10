package tests;

public class TestOrdenar {

	public static void main(String[] args) {

		int[] arr = nuevoArreglo();

		ordenarArreglo(arr);

	}

	private static int[] ordenarArreglo(int[] lista) {
		int ops = 0;
		ops = 1;
		for (int i = 0; i < lista.length; i++) {
			ops += 2;
			ops += 1;
			for (int j = i + 1; j < lista.length; j++) {
				ops += 2;
				if (lista[i] > lista[j]) {
					int aux = lista[i];
					lista[i] = lista[j];
					lista[j] = aux;
					ops += 4;
				} else {
					ops += 1;
				}
			}
		}
		
		System.out.println("Cantidad operaciones: " + ops);
		return lista;
	}

	private static int[] nuevoArreglo() {
		int[] lista = new int[200];
		for (int i = 0; i < 200; i++) {
			lista[i] = (int)(Math.random()*10000.0);
		}
		return lista;
	}
}
