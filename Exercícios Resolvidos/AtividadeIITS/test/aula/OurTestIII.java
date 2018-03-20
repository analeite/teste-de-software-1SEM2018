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
public class OurTestIII {

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }

	private Object a;
	private boolean saida;
	private Operacao op;

	@Before
	public void initialize() {
		op = new Operacao();
	}
	
	@After
	public void tearDown() {
		op = null;
	}

	public OurTestIII(Object a, boolean saida) {
		this.a = a;
		this.saida = saida;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> parametros() {
		return Arrays.asList(new Object[][] { 
			{ 12, true }, 
			{ 12.0, true },
			{ (char)12.0, false },
			{ "12", false },
			{ new Object(), false },
			{ null, false }});
	}
	
	@Test
	public void test3() throws Exception {
		System.out.println("Testando: " + saida);
		assertEquals(saida, op.isNumber(a));
	}

}
