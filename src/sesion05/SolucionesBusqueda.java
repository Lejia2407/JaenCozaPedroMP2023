package sesion05;

public class SolucionesBusqueda {

	public static Object busquedaBinariaRec(String[] array, String clave) {
		int primero = 0;
		int ultimo = array.length - 1;
		int central = array.length / 2;
		
		if ((clave.compareTo(array[0]) < 0) || (clave.compareTo(array[array.length - 1]) > 0))
		{
			return -1;
		}
		else
		{
			if(clave.compareTo(array[central]) == 0 ) {
				
			}
		}
			
			return 3;
	}
	
	//GTA150698 
	//TEST
}
