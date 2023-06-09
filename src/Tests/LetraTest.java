package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Consola.Letra;
import Consola.Letra.Estado;

public class LetraTest {

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
		Letra instance = new Letra("A", Estado.COLOCADA);
		
		String result = instance.toString();
		String expResult = "\033[32mA\t\033[0m";
		
		assertEquals(expResult, result);
	}

}
