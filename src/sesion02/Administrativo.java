package sesion02;

import java.util.GregorianCalendar;

public class Administrativo extends Empleado {
	private String unidad;

	public Administrativo(String nombre, String direccion, String telefono, String correoElectronico, String despacho,
			int salario, GregorianCalendar fechaContratacion, String unidad) {
		super(nombre, direccion, telefono, correoElectronico, despacho, salario, fechaContratacion);
		this.unidad = new String(unidad);
	}

	@Override
	public String toString() {
		return ("Administrativo\n" + super.toString() + "\nDestinado en la unidad " + unidad);
	}
}
