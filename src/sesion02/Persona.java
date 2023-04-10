package sesion02;

public class Persona {
	private String nombre;
	private String direccion;
	private String telefono;
	private String correoElectronico;

	public Persona(String nombre, String direccion, String telefono, String correoElectronico) {
		super();
		this.nombre = new String(nombre);
		this.direccion = new String(direccion);
		this.telefono = new String(telefono);
		this.correoElectronico = new String(correoElectronico);
	}

	@Override
	public String toString() {
		return ("Nombre = " + nombre + ", Dirección = " + direccion + ", Teléfono = " + telefono + ", email = "
				+ correoElectronico);
	}
}
