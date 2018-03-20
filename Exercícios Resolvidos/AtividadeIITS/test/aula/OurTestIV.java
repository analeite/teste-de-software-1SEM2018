package aula;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import aula.Operacao;

public class OurTestIV {

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }
	
	private Operacao op;

	@Before
	public void initialize() {
		op = new Operacao();
	}
	
	@After
	public void tearDown() {
		op = null;
	}
	
	@Test(timeout = 1100)
	public void test1() throws InterruptedException {
		System.out.println("Cont: 1, Tempo Limite: 1100 milissegundos");
		assertEquals(1, op.timer(1));
	}
	
	@Test(timeout = 3100)
	public void test2() throws InterruptedException {
		System.out.println("Cont: 3, Tempo Limite: 3100 milissegundos");
		assertEquals(1, op.timer(3));
	}

}
