package outro;

public class B extends aula.A {
	boolean isPar(int nro) {
		return nro % 2 == 1 ? true : false;
	}

	protected int menor(int x, int y) {
		return x < y ? y : x;
	}
}
