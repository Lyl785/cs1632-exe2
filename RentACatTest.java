import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.mockito.*;
import static org.mockito.Mockito.*;

public class RentACatTest {

	/**
     * The test fixture for this JUnit test.
     * Test fixture: a fixed state of a set of objects used as a baseline for running tests.
     * A test fixture is the JUnit term for a common precondition for all tests in this suite.
     */

	RentACat _r;        // Object to test
	@Mock Cat _c1;      // First mock cat object
	@Mock Cat _c2;      // Second mock cat object
	@Mock Cat _c3;      // Third mock cat object
	
	@Before
	public void setUp() throws Exception {
		// TODO: INITIALIZE THE TEST FIXTURE HERE.
		// 1. CREATE A NEW RENTACAT OBJECT BEFORE EACH TEST
		// 2. CREATE ALL MOCK CAT OBJECTS YOU WILL BE USING IN YOUR TESTS
		// 3. PERFORM ANY STUBBING REQUIRED FOR CAT METHODS YOU WILL BE CALLING	
		// (NOTE: THE DEFAULT BEHAVIOR FOR NON-STUBBED METHODS IS A NO-OP WITH 0 RETURN VALUE)
		_r = new RentACat();
		_c1 = Mockito.mock(Cat.class);
		_c2 = Mockito.mock(Cat.class);
		_c3 = Mockito.mock(Cat.class);
		_r._cats.add(_c1);
		_r._cats.add(_c2);
		_r._cats.add(_c3);
	}

	@Test
	public void testReturnCat() {
		when(_c1.getId()).thenReturn(1);
		when(_c1.getRented()).thenReturn(true);

		assertTrue(_r.returnCat(1));
	}

	@Test
	public void testRentCat() {
		when(_c1.getId()).thenReturn(1);
		when(_c1.getRented()).thenReturn(false);
		
		assertTrue(_r.rentCat(1));
	}

	@Test
	public void testListCats() {
		when(_c1.getId()).thenReturn(1);
		when(_c2.getId()).thenReturn(2);
		when(_c3.getId()).thenReturn(3);
		when(_c1.getRented()).thenReturn(false);
		when(_c2.getRented()).thenReturn(false);
		when(_c3.getRented()).thenReturn(false);
		when(_c1.getName()).thenReturn("Kat");
		when(_c2.getName()).thenReturn("Guy");
		when(_c3.getName()).thenReturn("Jimmy");

		assertEquals(_r.listCats(), "ID 1: Kat\nID 2: Guy\nID 3: Jimmy\n");
	}

	@Test
	public void testCatExists() {
		when(_c1.getId()).thenReturn(1);

		assertTrue(_r.catExits(1));
	}

	@Test
	public void testGetCat() {
		when(_c1.getId()).thenReturn(1);
		when(_c1.getName()).thenReturn("Jennyanydots");

		Cat c = _r.getCat(1);
		assertEquals(c.getName(), "Jennyanydots");
	}
    
	@After
	public void tearDown() throws Exception {
		_r = null;
		_c1 = null;
		_c2 = null;
		_c3 = null;
	}
	
	// TODO: ADD TEST CASES FOR EACH PUBLIC METHOD IN RENTACAT EXCEPT MAIN
}
