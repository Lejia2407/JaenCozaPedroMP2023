package sesion05;
import java.util.Comparator;

public class NumeroPaloComparator implements Comparator<Carta> {
	@Override
	public int compare(Carta c1, Carta c2) 
	{
		String[] palos = { "O", "C", "E", "B" };
		
		int valor = 0;
		
		if (c1 == c2)
			valor = 0;
		
		int palo1 = 0;
		
		int palo2 = 0;
		
		for (int i = 0; i < palos.length; i++) 
		{
			if (palos[i].equals(c1.getPalo()))
				palo1 = i;
			
			if (palos[i].equals(c2.getPalo()))
				palo2 = i;
		}
		
		if (c1.getNumero() > c2.getNumero())
			valor = 1;
		else if (c1.getNumero() < c2.getNumero())
			valor = -1;
		else 
		{
			if (palo1 > palo2)
				valor = 1;
			else if (palo1 < palo2)
				valor = -1;
			else
				valor = 0;
		}
		
		return valor;
	}
}