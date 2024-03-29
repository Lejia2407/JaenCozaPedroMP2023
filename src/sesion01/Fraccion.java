package sesion01;

public class Fraccion {

	private int numerador;
	private int denominador;

	public Fraccion() 
	{
		numerador = 0;
		denominador = 1;
	}

	public Fraccion(int numerador, int denominador) {
		this.numerador = ((denominador > 0) ? 1 : -1) * numerador;
		this.denominador = Math.abs(denominador);
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Fraccion))
			return false;
		Fraccion otro = (Fraccion) obj;
		if (denominador != otro.denominador)
			return false;
		if (numerador != otro.numerador)
			return false;
		return true;
	}


	public int getNumerador() {
		return numerador;
	}


	public int getDenominador() {
		return denominador;
	}


	public String toString() 
	{
		if (denominador == 1)
			return numerador + "";
		else
			return numerador + "/" + denominador;
		
	}

	public Fraccion sumar(Fraccion b) 
	{
		
		int num = numerador * b.getDenominador() + denominador * b.getNumerador();
		
		int den = denominador * b.getDenominador();
		return new Fraccion(num, den);
	}


	public Fraccion restar(Fraccion b) {
		int num = numerador * b.getDenominador() - denominador * b.getNumerador();
		int den = denominador * b.getDenominador();
		return new Fraccion(num, den);
	}

	public Fraccion multiplicar(Fraccion b) {

		return new Fraccion(numerador * b.getNumerador(), denominador * b.getDenominador());
	}


	public Fraccion dividir(Fraccion b) {
		return new Fraccion(numerador * b.getDenominador(), denominador * b.getNumerador());
	}


	private static int mcd(int i, int j) {
		i = Math.abs(i);
		j = Math.abs(j);
		if (j == 0) {
			return j;
		}
		int r;
		while (j != 0) {
			r = i % j;
			i = j;
			j = r;
		}
		return i;
	}

	public Fraccion simplificar() 
	{
		int dividir = mcd(numerador, denominador);
		numerador /= dividir;
		
		denominador /= dividir;
		return this;
	}


	public int compareTo(Object o) 
	{
		Fraccion otro = (Fraccion) o;
		double valorFraccion = (double) numerador / denominador;
		
		
		double valorOtro = (double) otro.getNumerador() / otro.getDenominador();
		if (valorFraccion > valorOtro)
			return 1;
		else if (valorFraccion < valorOtro)
			return -1;
		else
			return 0;
	}

}
