package sesion02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteradorPrimos implements Iterator<Integer> {
	private int limite;
	private int actual = 2;

	public IteradorPrimos(int limite) {
		super();
		this.limite = limite;
	}

	public int getLimite() {
		return limite;
	}

	public int getActual() {
		return actual;
	}

	public boolean hasNext() {
		if (actual <= limite)
			return true;
		else
			return false;
	}

	public Integer next() {
		if (actual > limite)
			throw new NoSuchElementException("No se puede acceder a más números primos");
		int temp = actual;
		do {
			actual++;
		} while (!esPrimo(actual));
		return temp;
	}

	public void remove() {
		throw new UnsupportedOperationException("Método no soportado");
	}

	public static boolean esPrimo(int numero) {
		int divisor = 2;
		boolean primo = true;
		for (divisor = 2; divisor < numero; divisor++) {
			if (numero % divisor == 0) {
				primo = false;
			}
		}
		return primo;
	}

	public String mostrarPrimos() {
		String s = "";
		int contador = 1;
		while (hasNext()) {
			if (contador % 10 == 0)
				s += "\t" + next() + "\n";
			else
				s += "\t" + next();
			contador++;
		}
		return s;
	}
}
