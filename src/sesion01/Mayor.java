package sesion01;

public class Mayor {

	public static int elEnteroMayor(int[] i) {
		
		if (i.length == 0) {
			throw new RuntimeException("Array vacio");
		}
		
		int maximo = Integer.MIN_VALUE;
		
		for (int indice = 0; indice < i.length; indice++) {
			
			if (i[indice] > maximo) {
				maximo = i[indice];
			}
		}
		return maximo;
	}
	
}
