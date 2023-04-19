package Tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Consola.TableroConsola;

public class TableroConsolaTest {

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
		TableroConsola instance = new TableroConsola();
		
		instance.desplegar();
		
		instance.getIntento("LAZAR", "PASTA");
		instance.desplegar();
		
		instance.getIntento("LAZAR", "LANZA");
		instance.desplegar();
		
		instance.getIntento("LAZAR", "LAzar");
		instance.desplegar();
		
		instance.getIntento("LAZAR", "Lzzar");
		instance.desplegar();
	}

}
