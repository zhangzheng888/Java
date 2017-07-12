import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the temperature conversions in TempConversion
 *
 * @author      Bill Barry
 * @version     2017-01-17
 */
public class TempConversionTest {

    /**
     * Default constructor for test class TempConversionTest
     */
    public TempConversionTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }
    
    @Test
    public void testFToC() {
        assertEquals(300.0, TempConversion.fToC(572.0), 0.0001);
    }

    @Test
    public void testFToK() {
        assertEquals(233.15, TempConversion.fToK(-40.0), 0.0001);
    }

    @Test
    public void testCToF() {
        assertEquals(50.0, TempConversion.cToF(10.0), 0.0001);
    }

    @Test
    public void testCToK() {
        assertEquals(13.15, TempConversion.cToK(-260.0), 0.0001);
    }

    @Test
    public void testKToF() {
        assertEquals(-382.0, TempConversion.kToF(43.15), 0.0001);
    }

    @Test
    public void testKToC() {
        assertEquals(30.0, TempConversion.kToC(303.15), 0.0001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testKToFPrecond() {
        assertEquals(999.99, TempConversion.kToF(-0.5), 0.0001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testKToCPrecond() {
        assertEquals(999.99, TempConversion.kToC(-200.0), 0.0001);
    }
}
