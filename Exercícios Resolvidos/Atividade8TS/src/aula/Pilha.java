package aula;

public class Pilha {
	
	private Object[] elementos;
	private int tamanho = 0;

	public Pilha(int maximo) {
		elementos = new Object[maximo];
	}

	public boolean estaVazia() {
		return tamanho == 0;
	}

	public int tamanho() {
		return tamanho;
	}

	public void empilhar(Object elemento) {
		if(tamanho == elementos.length) {
			throw new PilhaCheiaException(elemento);
		}
		this.elementos[tamanho] = elemento;
		tamanho++;
	}

	public Object topo() {
		return elementos[tamanho-1];
	}

	public Object desempilhar() {
		if(tamanho == 0) {
			throw new PilhaVaziaException();		
		}
		tamanho--;
		return elementos[tamanho];
	}

}
