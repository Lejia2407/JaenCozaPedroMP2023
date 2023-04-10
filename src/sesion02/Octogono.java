package sesion02;

public class Octogono extends ObjetoGeometrico implements Cloneable, Comparable<Object>, DeColor {
	private double lado;

	public Octogono() {
		super();
	}

	public Octogono(String color, boolean relleno, double lado) {
		super(color, relleno);
		this.lado = lado;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public double getPerimetro() {
		return (8 * lado);
	}

	@Override
	public double getArea() {
		return ((2 + (4 / Math.sqrt(2))) * lado * lado);
	}

	@Override
	public int compareTo(Object obj) {
		Octogono otro = (Octogono) obj;
		if (lado > otro.lado)
			return 1;
		if (lado < otro.lado)
			return -1;
		else
			return 0;
	}

	@Override
	public String comoColorear() {
		return "Colorear los 8 lados de " + color;
	}

	@Override
	protected Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException ex) {
			return null;
		}
	}
}
