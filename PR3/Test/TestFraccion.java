import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestFraccion {
	
	private Fraccion f;
	private Fraccion f2;
	
	@Before
	public void inti() {
		f = new Fraccion(2, 6);
		f2 = new Fraccion(1, -5);
	}

	
	@Test
	public void testSimplificacion() { 
		System.out.println( f );
		assertEquals(new Fraccion(1,3), f);
		assertEquals(1.0/3, 1.0*f.getNum()/f.getDen());
	}
	@Test
	public void testSigno() { 
		System.out.println( f2 );
		
	}
	@Test
	public void testSuma() {
		System.out.println( Fraccion.suma(f,f2) ); // 1/3 + (-1/5) = 2/15

	}
	@Test
	public void testResta() {
		System.out.println( Fraccion.resta(f,f2) ); // 1/3 - (-1/5) = 8/15

	}
	@Test
	public void testMultiplicacion() {
		System.out.println( Fraccion.multiplica(f,f2) ); // 1/3 * (-1/5) = -1/15

	}
	@Test
	public void testDivision() {
		System.out.println( Fraccion.divide(f,f2) ); // 1/3 / (-1/5) = -5/3	}


	}
}
