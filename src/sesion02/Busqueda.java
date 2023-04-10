package sesion02;

public class Busqueda {
	public static void busquedaBinaria(Double[] array, double clave) throws ExcepcionArrayVacio {
		if (array.length == 0)
			throw new ExcepcionArrayVacio("Array vacío");
	}

	public static Object busquedaBinaria(String[] array, String clave) {
		int primero = 0;
		int ultimo = array.length - 1;
		int central;
		if ((clave.compareTo(array[0]) < 0) || (clave.compareTo(array[array.length - 1]) > 0))
			return -1;
		else {
			while (ultimo >= primero) {
				central = (primero + ultimo) / 2;
				if (clave.compareTo(array[central]) < 0)
					ultimo = central - 1;
				else if (clave.compareTo(array[central]) > 0)
					primero = central + 1;
				else
					return central;
			}
			return -1;
		}
	}

	public static Object busquedaBinaria(Integer[] array, int clave) {
		int primero = 0;
		int ultimo = array.length - 1;
		int central;
		if (clave < array[0] || clave > array[array.length - 1])
			return -1;
		else {
			while (ultimo >= primero) {
				central = (primero + ultimo) / 2;
				if (clave < array[central])
					ultimo = central - 1;
				else if (clave > array[central])
					primero = central + 1;
				else
					return central;
			}
		}
		return -1;
	}

	public static Object busquedaBinaria(Fraccion[] array, Fraccion clave) {
		int primero = 0;
		int ultimo = array.length - 1;
		int central;
		if (clave.compareTo(array[0]) == -1 || clave.compareTo(array[array.length - 1]) == 1)
			return -1;
		else {
			while (ultimo >= primero) {
				central = (primero + ultimo) / 2;
				if (clave.compareTo(array[central]) == -1)
					ultimo = central - 1;
				else if (clave.compareTo(array[central]) == 1)
					primero = central + 1;
				else
					return central;
			}
		}
		return null;
	}
}
