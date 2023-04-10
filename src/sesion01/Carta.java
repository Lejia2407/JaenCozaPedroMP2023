package sesion01;

public class Carta implements Comparable{

	private String palo;
	private int numero;
	private int valor;
	
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
		
	}	

	public Carta(Carta carta) {
		super();
		this.palo = new String(carta.palo);
		this.numero = carta.numero;
		this.valor = carta.valor;
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
	
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		if (numero != other.numero)
			return false;
		if (palo == null) {
			if (other.palo != null)
				return false;
		} else if (!palo.equals(other.palo)) {
			return false;
		}
		if (valor != other.valor) {
			return false;
		}
		return true;
		
		
	}
	
	//GTA1S0115
	//GTA1S0279
	//GTA1S0523
	
}
