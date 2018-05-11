package aula;

public class PilhaCheiaException extends RuntimeException {

	private Object elemento;
	
	public PilhaCheiaException(Object elemento) {
		this.elemento = elemento;
	}

	public Object getElemento() {
		return elemento;
	}

}
