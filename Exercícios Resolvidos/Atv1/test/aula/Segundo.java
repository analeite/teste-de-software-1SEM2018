package aula;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Segundo {
	private A a;

	@Before
	public void setUp() {
		a = new A();
	}

	@Test
	public void a() {
		assertFalse(a.m(14));
	}

	@Test // (expected = Exception.class)
	public void b() {
		assertFalse(a.m(14));
	}

	@Test(expected = Exception.class)
	public void c() {
		assertFalse(a.m(null));
	}

	@Test
	public void d() throws Exception {
		assertEquals(1, a.n(1, 2), 0);
	}

	@Test(expected = Exception.class)
	public void e() throws Exception {
		assertEquals(2, a.n(2, 2), 0);
	}

	@Test
	public void f() {
		Pessoa p = new Pessoa();
		p.nome = "Ana";
		assertEquals(p, a.q());
	}

	@Test
	public void g() {
		Pessoa p = new Pessoa();
		p.nome = "Ana";
		assertSame(p, a.q());
	}

	// @Test(expected = Exception.class)
	// public void o() {
	// assertFalse(a.m(null));
	// }
	@Test
	public void h() {

		assertNull(a.o());

	}
	
	@Test
	public void i() {
		String str = "oi";
		assertSame(str, a.p());
	}

}
