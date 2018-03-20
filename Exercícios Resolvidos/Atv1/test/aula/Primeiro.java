package aula;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class Primeiro {
	@After
	public void a() {
		System.out.println("a");
	}

	@Before
	public void b() {
		System.out.println("b");
	}

	@AfterClass
	public static void c() {
		System.out.println("c");
	}

	@BeforeClass
	public static void d() {
		System.out.println("d");
	}

	@Ignore
	@Test
	public void e() {
		System.out.println("e");
	}

	@Test
	public void f() {
		System.out.println("f");
	}

	@Test
	public void g() {
		System.out.println("g");
	}
}