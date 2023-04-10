package sesion02;

	
public class MatrizFraccion extends MatrizGenerica<Fraccion> {

	protected Fraccion sumar(Fraccion o1, Fraccion o2) {
		return o1.sumar(o2);
	}

	protected Fraccion multiplicar(Fraccion o1, Fraccion o2) {
		return o1.multiplicar(o2);
	}

	protected Fraccion cero() {
		return new Fraccion();
	}

}
