package sesion02;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Empleado extends Persona {
	private String despacho;
	private int salario;
	private GregorianCalendar fechaContratacion;

	public Empleado(String nombre, String direccion, String telefono, String correoElectronico, String despacho,
			int salario, GregorianCalendar fechaContratacion) {
		super(nombre, direccion, telefono, correoElectronico);
		this.despacho = despacho;
		this.salario = salario;
		this.fechaContratacion = fechaContratacion;
	}

	@Override
	public String toString() {
		return (super.toString() + "\nDespacho = " + despacho + ",salario = " + salario + ", Fecha de contratación = "
				+ fechaContratacion.get(Calendar.DATE) + "/" + (fechaContratacion.get(Calendar.MONTH) + 1) + "/"
				+ fechaContratacion.get(Calendar.YEAR));
	}
}