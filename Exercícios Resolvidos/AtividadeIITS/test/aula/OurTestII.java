package aula;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import aula.Operacao;

@RunWith(Parameterized.class)
public class OurTestII {

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }

	private double a;
	private double b;
	private double saida;
	private Operacao op;

	@Before
	public void initialize() {
		op = new Operacao();
	}
	
	@After
	public void tearDown() {
		op = null;
	}

	public OurTestII(double a, double b, double saida) {
		this.a = a;
		this.b = b;
		this.saida = saida;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> parametros() {
		return Arrays.asList(new Object[][] { 
			{ -1, 0, -1 }, 
			{ 0, -1, -1  }, 
			{ -1, -1, 1 }});
	}
	
	@Test(expected=Exception.class)
	public void test2() throws Exception {
		System.out.println("Testando: " + saida);
		assertEquals(saida, op.areaRetangulo(b, a), 0);
	}

}
