package sesion05;

public class SolucionesBusqueda {
	
	public static int busquedaLineal(Busqueda busqueda) throws ElementoNoEncontradoException 
	{
		int buscado;
		
		buscado = busqueda.getNumBuscado();
		
		boolean encontrado = false;
		int[] datos = busqueda.getDatos();
		
		for (int i = 0; i < datos.length; i++) 
		{
			if (buscado == datos[i]) 
			{
				encontrado = true;
				break;
			}
		}
		
		if (!encontrado)
			throw new ElementoNoEncontradoException("No encontrado");
		
		return buscado;
	}

	public static int busquedaBinariaIter(Busqueda busqueda) throws ElementoNoEncontradoException 
	{
		int primero = 0;
		int[] datos = busqueda.getDatos();
		int ultimo = datos.length - 1;
		int central;
		int clave = busqueda.getNumBuscado();
		
		if (clave < datos[0] || clave > datos[datos.length - 1])
			return -1;
		else 
		{
			while (ultimo >= primero) 
			{
				central = (primero + ultimo) / 2;
				
				if (clave < datos[central])
					ultimo = central - 1;
				else if (clave > datos[central])
					primero = central + 1;
				else
					return central;
			}
		}
		
		throw new ElementoNoEncontradoException("No encontrado");
	}

	public static int busquedaBinariaRec(Busqueda busqueda) throws ElementoNoEncontradoException 
	{
		int buscado = busqueda.getNumBuscado();
				
		return buscado;
	}


}

// GTA150698
//test
