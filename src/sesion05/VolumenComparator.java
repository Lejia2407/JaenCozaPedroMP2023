package sesion05;

import java.util.Comparator;

public class VolumenComparator implements Comparator<Accion> {
	@Override
	public int compare(Accion o1, Accion o2) 
	{
		if (o1 == o2)
			return 0;
		else if (o1.getVolumen() > o2.getVolumen())
			return 1;
		else
			return -1;
		
	}
}