package sesion02;

import java.util.GregorianCalendar;

public class Profesor extends Empleado {
	private String horario;
	private int categoria;

	public Profesor(String nombre, String direccion, String telefono, String correoElectronico, String despacho,
			int salario, GregorianCalendar fechaContratacion, String horario, int categoria) {
		super(nombre, direccion, telefono, correoElectronico, despacho, salario, fechaContratacion);
		this.horario = new String(horario);
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		String s = "Profesor ";
		switch (categoria) {
		case 1:
			s += "Ayudante\n";
			break;
		case 2:
			s += "Titular de Universidad\n";
			break;
		case 3:
			s += "Catedrático de Universidad\n";
			break;
		}
		return (s + super.toString() + "\nHorario = " + horario);
	}
}