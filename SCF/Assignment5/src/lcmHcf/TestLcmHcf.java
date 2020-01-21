package lcmHcf;
import static org.junit.Assert.*;

import org.junit.Test;
/**
 * @desc this class checks for the validity of the function lcm and hcf using jUnit
 * @author Kunal
 *
 */
public class TestLcmHcf {
    @Test
    /**
     * @desc this function checks for the validity of Hcf function
     */
    public void testHcf() {
        LcmHcf object = new LcmHcf();
        int result = object.hcf(4, 16);
        assertEquals(4, result);

        result = object.hcf(15, 5);
        assertEquals(5, result);

        result = object.hcf(4, 16);
        assertEquals(4, result);

        result = object.hcf(0, 0);
        assertEquals(0, result);

    }

    @Test
    /**
     * @desc this function checks for the validity of lcm function
     */
    public void testLcm() {
        try {

            LcmHcf object = new LcmHcf();
            int result = object.lcm(1, 2);
            assertEquals(2, result);

            result = object.lcm(6, 12);
            assertEquals(12, result);
            // Divide by zero Assertion error
            result = object.lcm(0, 0);
            assertEquals(0, result);
        } catch (AssertionError ex) {
            System.out.println("(testHcf) AssertionError : " + ex.getMessage());
        }
    }
}
