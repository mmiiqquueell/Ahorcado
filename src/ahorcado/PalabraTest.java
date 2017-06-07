package ahorcado;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PalabraTest {
	private Palabra p1;

	@Before
	public void setUp() throws Exception {
		p1 = new Palabra();
		p1.elegirPalabra();
	}

	@Test
	public void testComprobarletraUsada() {
		p1.comprobarLetra('a');
		p1.comprobarLetra('d');
		assertTrue(p1.comprobarLetraUsada('a'));
		assertFalse(p1.comprobarLetraUsada('t'));
	}

}
