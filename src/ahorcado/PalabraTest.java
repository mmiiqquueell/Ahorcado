package ahorcado;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class PalabraTest {
	private Palabra p1;

	@Before
	public void setUp() throws Exception {
		p1 = new Palabra();
	}

	@Test
	public void testElegirPalabra() {

		assertNotNull(p1.elegirPalabra());
	}

	public void testComprobarletraUsada() {

	}

}
