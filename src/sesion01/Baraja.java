package sesion01;

public class Baraja {
	private String nombreBaraja;
	private Carta[] cartas;

	public Baraja(String nombreBaraja, Carta[] cartas) {
		super();
		this.nombreBaraja = new String(nombreBaraja);
		if (cartas != null) {
			this.cartas = new Carta[cartas.length];
			for (int i = 0; i < this.cartas.length; i++) {
				this.cartas[i] = new Carta(cartas[i]);
			}
		}
	}

	public String getNombreBaraja() {
		return nombreBaraja;
	}

	public Carta[] getCartas() {
		return cartas;
	}

	public static void insercion(Carta[] a) {
		for (int i = 1; i < a.length; i++) {
			Carta aux = a[i];
			int j;
			for (j = i - 1; j >= 0 && aux.compareTo(a[j]) == -1; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = aux;
		}
	}
}