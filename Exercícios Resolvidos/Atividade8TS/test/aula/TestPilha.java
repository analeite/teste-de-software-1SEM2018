package aula;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPilha {

	//Exercício 1
	//Link para o vídeo do Eduardo Guerra
	//https://www.youtube.com/watch?v=QxRR1Dh77DM
	
	//Inicialização
	private Pilha p;
	
	@Before
	public void setUp() {
		p = new Pilha(10);
	}
	
	//Pilha Vazia
	@Test
	public void pilhaVazia() {
		assertTrue(p.estaVazia());
		assertEquals(0, p.tamanho());
	}
	
	//Adicionar um elemento
	@Test
	public void adicionarUmElemento() {
		p.empilhar("A");
		assertFalse(p.estaVazia());
		assertEquals("A", p.topo());
	}
	
	//Adicionar dois elementos
	@Test
	public void adicionarDoisElementos() {
		p.empilhar("A");
		p.empilhar("B");
		assertEquals(2, p.tamanho());
		assertEquals("B", p.topo());
	}
	
	//Desempilhar Elemento
	@Test
	public void desempilharElemento() {
		p.empilhar("A");
		p.empilhar("B");
		assertEquals(2, p.tamanho());
		assertEquals("B", p.topo());
		Object desempilhado = p.desempilhar();
		assertEquals(1, p.tamanho());
		assertEquals("A", p.topo());
		assertEquals("B", desempilhado);		
	}
	
	//Desempilhar da pilha vazia
	@Test(expected=PilhaVaziaException.class)
	public void desempilharDaPilhaVazia() {
		p.desempilhar();
	}
	
	//Empilhar na pilha cheia
	@Test//(expected=PilhaCheiaException.class)
	public void empilharNaPilhaCheia() {
		for(int i = 0; i < 10; i++) {
			p.empilhar("Elemento"+i);
		}
		try {
			p.empilhar("Boom!!");
			fail();
		}catch(PilhaCheiaException ex) {
			assertEquals("Boom!!", ex.getElemento());
		}
	}

}
