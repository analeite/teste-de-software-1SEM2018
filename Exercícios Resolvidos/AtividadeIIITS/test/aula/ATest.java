package aula;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ATest {

	// Quest�o 1: Resposta: Um m�todo com retorno void � dif�cil de ser checado,
	// pois n�o retorna um valor para ser comparado. Pode ser feito ent�o uma
	// verifica��o se a a��o foi efetuada pelo m�todo. Por n�o haver uma a��o
	// de retorno no m�todo, n�o fica claro qual � a a��o a ser verificada.
	
	//Quest�o 2
	@Mock
	private A a;

	@Test(expected = Exception.class)
	public void test1() throws Exception {
		doThrow(new Exception("Teste de Exce��o")).when(a).g(5);
	}

	@Test(expected = Exception.class)
	public void test2() throws Exception {
		doThrow(new Exception("Teste de Exce��o")).when(a).g(15);
	}
	
//	Quest�o 3: Mesmo que n�o esteja definido, por padr�o, sabemos que o m�todo esta com visibilidade protected. 
//	Isso faz com que ele seja acessado somente pelo mesmo pacote. Isso explica porque o m�todo isParTest 
//	n�o pode ser testado. 

//	Quest�o 4: N�o � poss�vel testar o m�todo menorTest() porque ele n�o est� no
//	pacote aula, mas sim no pacote outro.
//	Este m�todo, por ser protected s� pode acessar classes do mesmo pacote. Ent�o
//	seria necess�rio
//	manter a classe de testes no mesmo pacote que se encontra a classe a ser
//	testada.

	//Quest�o 5
	@Before
	public void setUp() {
		a = new A();
	}
	
	@Test
	public void testDobroA() {
		try {
			Method metodoDobro = A.class.getDeclaredMethod("dobro", int.class);
			metodoDobro.setAccessible(true);
			int r = (int) metodoDobro.invoke(a, 20);
			assertEquals(40, r, 0);
		} catch (NoSuchMethodException|SecurityException|IllegalAccessException|
				 IllegalArgumentException|InvocationTargetException e) {
			 e.printStackTrace();
			 }
	}
	
	//Quest�o 6
	@Test(expected = Exception.class)
	public void test3() throws Exception {
		doThrow(new Exception("Teste de Exce��o")).when (new A(12.5));
	}
	
	@Test(expected = Exception.class)
	public void test4() throws Exception {
		doThrow(new Exception("Teste de Exce��o")).when (new A("12.5"));
	}
	
	//Quest�o 7
	@Test
	public void test5() throws Exception {
		assertEquals("10 - 6 = 4", 4, A.diff(10, 6));
	}
	
	//Quest�o 8
	@Test
	public void test6() {
		A a = new A();
		A.C c = a.new C();
		assertEquals(5, c.soma(3, 2), 0);
	}
	
	//Quest�o 9: O assertEquals � utilizado para testar se o resultado
	//confere com o valor esperado. No segundo assertEquals do modTest()
	//o resto da divis�o n�o � 2, e sim 3 (por o resultado
	//ser 2,75, o programa arredonda para 3 automaticamente). Logo, como o teste n�o passa
	//o valor esperado, ele ignora o terceiro assertEquals e n�o o testa.
	//Por isso � indicado que se fa�a uma asser��o por teste.
	
	
	@Test
	public void modTest() {
	 System.out.println("Primeiro");
	 assertEquals("11%2 == 1", 1, a.mod(11,2) );
	 System.out.println("Segundo");
	 assertEquals("11%4 == 3", 3, a.mod(11,4) );
	 System.out.println("Terceiro");
	 assertEquals("11%3 == 2", 2, a.mod(11,3) );
	}

	}


