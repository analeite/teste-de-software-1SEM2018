package aula;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SenaTest {

	private Sena sena;

	@Before
	public void setUp() {
		sena = new Sena();
	}

	// Exercício a)
	@Test
	public void hasSizeTest() throws Exception {
		// java.util.List<Integer> sena = java.util.Arrays.asList(5, 2, 4, 3, 1, 7);
		assertThat(sena.getSena(6), hasSize(6));
	}

	// Exercício b)
	@Test
	public void testIntervalo() throws Exception {
		assertThat(sena.getSena(10), everyItem(not(allOf(greaterThanOrEqualTo(1), greaterThanOrEqualTo(60)))));
	}

	// Exercício c)
	@Test
	public void exercC() throws Exception {
		assertThat(sena.getSena(10), ordenado());
	}

	private TypeSafeMatcher<List<Integer>> ordenado() {
		return new TypeSafeMatcher<List<Integer>>() {

			@Override
			protected boolean matchesSafely(List<Integer> lista) {
				for (int i = 0; i < lista.size() - 1; i++) {
					if (lista.get(i) <= lista.get(i + 1)) {
						return true;
					}
				}
				return false;
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("Describe the error has you like more.");
			}
		};
	}
	
	//Exercício d)
	@Test
	public void exercD() throws Exception {
		assertThat(sena.getSena(10), duplicado());
	}

	private TypeSafeMatcher<List<Integer>> duplicado() {
		return new TypeSafeMatcher<List<Integer>>() {

			@Override
			protected boolean matchesSafely(List<Integer> lista) {
				for (int i = 0; i < lista.size() - 1; i++) {
					if (lista.get(i) == lista.get(i + 1)) {
						return true;
					}
				}
				return false;
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("Describe the error has you like more.");
			}
		};
	}
	
	//Exercício e
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void exercE() throws Exception{
		thrown.expect(Exception.class);
		sena.getSena(null);
	}
	
	//Exercício f
	@Test
	public void exercF() throws Exception{
		thrown.expect(Exception.class);
		thrown.expectMessage("Mínimo 6");
		sena.getSena(5);
	}
	
	//Exercício g		
		@Test
		public void exercG() throws Exception{
			thrown.expect(Exception.class);
			thrown.expectMessage("Máximo 12");
			sena.getSena(13);
		}
	
}
