package aula;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ATest {

	// Questão 1: Resposta: Um método com retorno void é difícil de ser checado,
	// pois não retorna um valor para ser comparado. Pode ser feito então uma
	// verificação se a ação foi efetuada pelo método. Por não haver uma ação
	// de retorno no método, não fica claro qual é a ação a ser verificada.
	
	//Questão 2
	@Mock
	private A a;

	@Test(expected = Exception.class)
	public void test1() throws Exception {
		doThrow(new Exception("Teste de Exceção")).when(a).g(5);
	}

	@Test(expected = Exception.class)
	public void test2() throws Exception {
		doThrow(new Exception("Teste de Exceção")).when(a).g(15);
	}
	
//	Questão 3: Mesmo que não esteja definido, por padrão, sabemos que o método esta com visibilidade protected. 
//	Isso faz com que ele seja acessado somente pelo mesmo pacote. Isso explica porque o método isParTest 
//	não pode ser testado. 

//	Questão 4: Não é possível testar o método menorTest() porque ele não está no
//	pacote aula, mas sim no pacote outro.
//	Este método, por ser protected só pode acessar classes do mesmo pacote. Então
//	seria necessário
//	manter a classe de testes no mesmo pacote que se encontra a classe a ser
//	testada.

	//Questão 5
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
	
	//Questão 6
	@Test(expected = Exception.class)
	public void test3() throws Exception {
		doThrow(new Exception("Teste de Exceção")).when (new A(12.5));
	}
	
	@Test(expected = Exception.class)
	public void test4() throws Exception {
		doThrow(new Exception("Teste de Exceção")).when (new A("12.5"));
	}
	
	//Questão 7
	@Test
	public void test5() throws Exception {
		assertEquals("10 - 6 = 4", 4, A.diff(10, 6));
	}
	
	//Questão 8
	@Test
	public void test6() {
		A a = new A();
		A.C c = a.new C();
		assertEquals(5, c.soma(3, 2), 0);
	}
	
	//Questão 9: O assertEquals é utilizado para testar se o resultado
	//confere com o valor esperado. No segundo assertEquals do modTest()
	//o resto da divisão não é 2, e sim 3 (por o resultado
	//ser 2,75, o programa arredonda para 3 automaticamente). Logo, como o teste não passa
	//o valor esperado, ele ignora o terceiro assertEquals e não o testa.
	//Por isso é indicado que se faça uma asserção por teste.
	
	
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


