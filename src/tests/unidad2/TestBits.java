package tests.unidad2;

public class TestBits {
	public static void main(String[] args) {
		
		for (int a = 0; a < 35; a++) {
			System.out.println("En base 10: " + a + 
					"  | y en base 16: " + String.format("%x", a) +
					"  | y en base 2: " + Integer.toBinaryString(a));
		}
		
		int r = 59;
		int g = 152;
		int b = 201;
		
		int base = 256;
		int color = 59 * base * base + 152 * base + 201;
		
		System.out.println("Color de (59,152,201): " + color);
		System.out.println("Color de (" + String.format("%x", r) + "," + 
				String.format("%x", g) + "," + 
				String.format("%x", b) + "): " + String.format("%x", color));
		System.out.println("Color de (" + Integer.toBinaryString(r) + "," + 
				Integer.toBinaryString(g) + "," + 
				Integer.toBinaryString(b) + "): " + 
				Integer.toBinaryString(color) + " | " +
				String.format("%x", color) + " | " + color);
		
		int colorA = (r << 16) | (g << 8) | b;
		System.out.println("Color de (" + Integer.toBinaryString(r) + "," + 
				Integer.toBinaryString(g) + "," + 
				Integer.toBinaryString(b) + "): " + 
				Integer.toBinaryString(colorA) + " | " +
				String.format("%x", colorA) + " | " + colorA);
		
		int soloVerde = (colorA >> 8) & 0x000000ff;
		System.out.println("Solo verde: " + soloVerde);
		
		System.out.println();
		System.out.println("BITWISE");
		System.out.println();
		
		int colorB = color >> 4;
		System.out.println(Integer.toBinaryString(color) + " >> 4 lugares: " + 
				Integer.toBinaryString(colorB));
		int colorC = color << 3;
		System.out.println(Integer.toBinaryString(color) + " << 3 lugares: " + 
				Integer.toBinaryString(colorC));
		
		int n1 = 20;
		int n1izq = n1 << 1;
		System.out.println(n1 + " | " + Integer.toBinaryString(n1) + " << 1 lugar: " + 
				Integer.toBinaryString(n1izq) + " | " + n1izq );
		int n1der = n1 >> 1;
		System.out.println(n1 + " | " + Integer.toBinaryString(n1) + " >> 1 lugar: " + 
				Integer.toBinaryString(n1der) + " | " + n1der );
		
		
		int m1 = 7;
		int m2 = 7;
		
		// 111000011100
		// m1 3 ceros m2 2 ceros
		// m1 recorrer 8 lugares
		// 111 0000 0000
		// m2 recorrer 2 lugares
		// 111 00
		
		// 11100000000
		// 00000011100
		//-------------
		// 11100011100
		
		// 11100(10100)1101
		// 00000 11111 0000
		// &
		// 00000 10100 0000
		
		// En base 10: 
		// 537 = 5 * base^2 + 3 * base + 7
		
		
		// 2147483647 
		// 4294967296
		
		// 00 AB 5F 3E
	}
	
	
}
