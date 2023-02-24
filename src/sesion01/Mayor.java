package sesion01;

public class Mayor {

	public static int elEnteroMayor(int[] a) {
		
		int max = Integer.MAX_VALUE;
	
		for (int indice = 0; indice < a.length -1 ; indice++) {  
			if (a[indice] > max) {
				max = a[indice];
			}
		}
		return max;
	}
	
}
