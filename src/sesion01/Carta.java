package sesion01;

public class Carta implements Comparable{

	private String palo;
	private int numero;
	private int valor;
	
	/**
	 * Instantiates a new carta.
	 *
	 * @param j the j
	 * @param i the i
	 */
	public Carta(String j, int i) {
		
		switch(j)
		{
			case "O":
				valor = i + 0;
				break;
				
			case "C":
				valor = i + 12;
				break;
				
			case "E":
				valor = i + 24;
				break;
				
			case "B":
				valor = i + 36;
				break;
					
			default:
				valor = -1;
		}	
		
		this.palo = j;
		this.numero = i;
		
	}	
	
	public int getValor () {
		return valor;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getPalo() {
		return palo;
	}
	
	public int compareTo(Object o) {
		
		Carta hola = (Carta) o;
		
		int indice;
		
		indice = hola.getValor() - this.valor;
		
		return indice;
	
	}
	
	//GTA1S0115
	//GTA1S0279
	
}
