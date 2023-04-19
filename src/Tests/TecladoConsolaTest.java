package Tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Consola.TecladoConsola;

public class TecladoConsolaTest {

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
	public void test() {
		TecladoConsola instance = new TecladoConsola();
		instance.desplegar();
		
		instance.getIntento("ABEJA", "PESCA");
		instance.desplegar();
	}
}
