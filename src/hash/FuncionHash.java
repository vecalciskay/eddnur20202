package hash;

public class FuncionHash {

	public long hash(String palabra) {
		long result = 0;
		
		for(int i=0; i<palabra.length(); i++)  {
			char c = palabra.charAt(i);
			result += c;
		}
		
		return result;
	}
}
