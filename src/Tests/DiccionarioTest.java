package Tests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Wordle.Diccionario;

public class DiccionarioTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVerificarPalabraTRUE() {
		boolean result = Diccionario.verificarPalabra("arbol");
		assertEquals(true, result);
	}

	@Test
	public void testVerificarPalabraFALSE() {
		boolean result = Diccionario.verificarPalabra("kadir");
		assertEquals(false, result);
	}
	
	@Test
	public void testGenerarPalabra() {
		String result = Diccionario.generarPalabra();
		System.out.println("Palabra generada: " + result);
		assertNotEquals(null, result);
	}
}
