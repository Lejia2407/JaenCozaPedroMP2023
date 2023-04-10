package sesion02;

import java.util.GregorianCalendar;

public abstract class ObjetoGeometrico {
	protected String color;
	protected boolean relleno;
	protected GregorianCalendar fechaCreado;

	protected ObjetoGeometrico() {
		super();
		this.color = "blanco";
	}

	protected ObjetoGeometrico(String color, boolean relleno) {
		this.color = new String(color);
		this.relleno = relleno;
		this.fechaCreado = new GregorianCalendar();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean esRelleno() {
		return relleno;
	}

	public void setRelleno(boolean relleno) {
		this.relleno = relleno;
	}

	public GregorianCalendar getFechaCreado() {
		return fechaCreado;
	}

	@Override
	public String toString() {
		return "Creado el " + fechaCreado + "\ncolor: " + color + " y relleno: " + relleno;
	}

	public abstract double getPerimetro();

	public abstract double getArea();
}
