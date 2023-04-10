package sesion02;

public class MatrizInteger extends MatrizGenerica<Integer> {

	@Override
	protected Integer sumar(Integer i1, Integer i2) {
		return i1 + i2;
	}


	@Override
	protected Integer multiplicar(Integer i1, Integer i2) {
		return i1 * i2;
	}

	@Override
	protected Integer cero() {
		return 0;
	}
}