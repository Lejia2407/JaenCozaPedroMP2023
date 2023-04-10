package sesion02;

public class Estudiante extends Persona {
	private int nivel;

	public Estudiante(String nombre, String direccion, String telefono, String correoElectronico, int nivel) {
		super(nombre, direccion, telefono, correoElectronico);
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		String s = "Estudiante de ";
		switch (nivel) {
		case 1:
			s += "Grado\n";
			break;
		case 2:
			s += "Máster\n";
			break;
		case 3:
			s += "Doctorado\n";
			break;
		}
		return (s + super.toString());
	}
}
