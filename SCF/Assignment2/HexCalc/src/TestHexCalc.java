import static org.junit.Assert.*;

import org.junit.Test;

/**
 * this class checks the validity of class HexCalc
 * 
 * @author Kunal
 *
 */
public class TestHexCalc {
    /**
     * Test the validity of hexToCalc()
     */
    @Test
    public void hexToDeciTest() {
        HexCalc object = new HexCalc();
        int result = object.hexToDeci("A");
        int compare = 10;
        assertEquals(compare, result);
    }

    /**
     * Test the validity of deciToHex()
     */
    @Test
    public void deciToHexTest() {
        HexCalc object = new HexCalc();
        String result = object.deciToHex(10);
        String compare = "A";
        assertEquals(compare, result);
    }

    /**
     * Test the validity of add()
     */
    @Test
    public void addTest() {
        HexCalc object = new HexCalc();
        String result = object.add("A", "2");
        String compare = "C";
        assertEquals(compare, result);
    }

    /**
     * Test the validity of subtract()
     */
    @Test
    public void subtractTest() {
        HexCalc object = new HexCalc();
        String result = object.subtract("A", "2");
        String compare = "8";
        assertEquals(compare, result);
    }

    /**
     * Test the validity of multiply()
     */
    @Test
    public void multiplyTest() {
        HexCalc object = new HexCalc();
        String result = object.multiply("A", "2");
        String compare = "14";
        assertEquals(compare, result);
    }

    /**
     * Test the validity of divide()
     */
    @Test
    public void divideTest() {
        HexCalc object = new HexCalc();
        String result = object.divide("A", "2");
        String compare = "5 ,remainder is 0";
        assertEquals(compare, result);
    }

    /**
     * Test the validity of firstGreaterThenSecond()
     */
    @Test
    public void firstGreaterThenSecondTest() {
        HexCalc object = new HexCalc();
        Boolean result = object.firstGreaterThenSecond("A", "2");
        Boolean compare = true;
        assertEquals(compare, result);
    }

    /**
     * Test the validity of firstLessThenSecond()
     */
    @Test
    public void firstLessThenSecondTest() {
        HexCalc object = new HexCalc();
        Boolean result = object.firstLessThenSecond("A", "2");
        Boolean compare = false;
        assertEquals(compare, result);
    }

    /**
     * Test the validity of firstEqualsToSecond()
     */
    @Test
    public void firstEqualsToSecondTest() {
        HexCalc object = new HexCalc();
        Boolean result = object.firstEqualsToSecond("A", "2");
        Boolean compare = false;
        assertEquals(compare, result);
    }

    /**
     * negative test case i.e, where String is invalid
     */
    @Test
    public void checkVaildStringTest() {
        HexCalc object = new HexCalc();
        Boolean result = object.checkVaildString("A@12");
        Boolean compare = false;
        assertEquals(compare, result);
    }

}
