package ahorcado;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class HorcaTest {
	private Horca h1;

	@Before
	public void setUp() throws Exception {
		h1 = new Horca();
	}

	// @Test
	// public void testDibujar() {
	// fail("Not yet implemented");
	// }

	@Test
	public void testIncrementarFallo() {
		h1.incrementarFallo();
		assertEquals(h1.getFallos(), 1);
	}

	@Test
	public void testComprobarSiPerdido() {
		for (int i = 0; i < h1.MAX_FALLOS - 1; i++) {
			h1.incrementarFallo();
			// System.out.println(h1.comprobarSiPerdido() + " / " + i);
			assertFalse(h1.comprobarSiPerdido());
		}
		h1.incrementarFallo();
		assertTrue(h1.comprobarSiPerdido());
	}

}
