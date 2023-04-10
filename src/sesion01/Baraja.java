package sesion01;

import java.util.Random;

public class Baraja {

	private String nombreBaraja;
	private Carta[] cartas;
	
	public Baraja(String barajaNombre, Carta[] cartas) {
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
	
	public static void insercion(Carta[] temporal) {
		
		for (int i = 1; i < temporal.length; i++) {
			
			Carta indice = temporal[i];
			int j;
			for ( j = i - 1; j >= 0 && indice.compareTo(temporal[j]) == -1; j--) {
				
				temporal[j + 1] = temporal[j];
			}
			temporal[j + 1] = indice;
		}
	}
	
}
