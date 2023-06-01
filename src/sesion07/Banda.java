package sesion07;

public class Banda<T extends Number> {
	private String nombreBanda;
	private T[][] datos;


	public Banda(String nombre, int x, int y) {
		this.nombreBanda = nombre;
		this.datos = (T[][]) new Number[y][x];
	}

	public Banda(String nombre, T[][] datos) {
		this.nombreBanda = nombre;
		this.datos = datos;
	}

	public String getNombreBanda() {
		return this.nombreBanda;
	}

	public void setNombreBanda(String nombreBanda) {
		this.nombreBanda = nombreBanda;
	}

	public T[][] getDatos() {
		return datos;
	}

	public void setDatos(T[][] datos) {
		this.datos = datos;
	}

	public T getDatoXY(int x, int y) {
		return datos[x][y];
	}

	public void setDatoXY(T dato, int x, int y) {
		this.datos[x][y] = dato;
	}

	public String toString() {
		String salida = nombreBanda + ": \n";
		for (int i = 0; i < datos.length; i++) {
			for (int j = 0; j < datos[0].length; j++) {
				salida += datos[i][j] + " ";
			}
			salida += "\n";
		}
		return salida;
	}
}