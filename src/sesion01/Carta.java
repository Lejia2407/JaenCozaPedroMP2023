package sesion01;

public class Carta implements Comparable<Object> {
	private String palo;
	private int numero;
	private int valor;

	public Carta(String palo, int numero) {
		super();
		this.palo = new String(palo);
		this.numero = numero;
		switch (palo) {
		case "O":
			valor = numero;
			break;
		case "C":
			valor = numero + 12;
			break;
		case "E":
			valor = numero + 24;
			break;
		case "B":
			valor = numero + 36;
			break;
		}
	}

	public Carta(Carta carta) {
		super();
		this.palo = new String(carta.palo);
		this.numero = carta.numero;
		this.valor = carta.valor;
	}

	public String getPalo() {
		return palo;
	}

	public int getNumero() {
		return numero;
	}

	public int getValor() {
		return valor;
	}

	@Override
	public boolean equals(Object obj) {
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
		} else if (!palo.equals(other.palo))
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {
		Carta otro = (Carta) o;
		if (valor == otro.valor)
			return 0;
		if (valor > otro.valor)
			return 1;
		else
			return -1;
	}
}

// GTA1S0115
// GTA1S0279
// GTA1S0523
