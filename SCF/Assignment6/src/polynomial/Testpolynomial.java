package polynomial;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @desc this class is to test the cases for class Polynomial
 * @author Kunal
 *
 */
public class Testpolynomial {
    Polynomial p1;
    Polynomial p2;
    Polynomial p3;
    Polynomial p4;
    Polynomial p5;
    Polynomial p6;

    /**
     * @desc this function initialize all the polynomials
     */
    @Before
    public void beforeTest() {
        p1 = new Polynomial(new int[] { 4, 2, 1 }, new int[] { 3, 2, 1 });
        p2 = new Polynomial(new int[] { 4, 2, 1 }, new int[] { 1, 2, 1 });
        p3 = new Polynomial(new int[] { 2, 1 }, new int[] { 2, 1 });
        p4 = new Polynomial(new int[] { 1, 1 }, new int[] { 2, 1 });
        p5 = new Polynomial(new int[] { 4, 2, 1 }, new int[] { 1, 1, 1 });
        p6 = new Polynomial(new int[] { 1, 10 }, new int[] { 1, 2 });
    }

    /**
     * @desc this function checks the validity of evaluate() of class Polynomial
     */
    @Test
    public void testForEvaluate() {
        float result = p3.evaluate(4);
        float expected = 36;
        assertEquals(expected, result, 2);

        float result1 = p3.evaluate(5);
        float expected1 = 55;
        assertEquals(expected1, result1, 2);

    }

    /**
     * @desc this function checks the validity of degree() of class Polynomial
     */
    @Test
    public void testForDegree() {

        int result = p1.degree();
        int expected = 4;
        assertEquals(expected, result);

        int result1 = p3.degree();
        int expected1 = 2;
        assertEquals(expected1, result1);

    }

    /**
     * @desc this function checks the validity of addPoly() of class Polynomial
     */
    @Test
    public void testForaddPoly() {
        Polynomial result;
        result = Polynomial.addPoly(p1, p2);
        assertArrayEquals(new int[] { 4, 2, 1 }, result.getDegree());
        assertArrayEquals(new int[] { 4, 4, 2 }, result.getCoEfficient());

        result = Polynomial.addPoly(p1, p5);
        assertArrayEquals(new int[] { 4, 2, 1 }, result.getDegree());
        assertArrayEquals(new int[] { 4, 3, 2 }, result.getCoEfficient());

    }

    /**
     * @desc this function checks the validity of multiplyPoly() of class
     *       Polynomial
     */
    @Test
    public void testForMultiplyPoly() {
        Polynomial result;

        result = Polynomial.multiplyPoly(p5, p6);
        assertArrayEquals(new int[] { 5, 14, 3, 12, 2, 11 }, result.getDegree());
        assertArrayEquals(new int[] { 1, 2, 1, 2, 1, 2 },
                result.getCoEfficient());

        result = Polynomial.multiplyPoly(p1, p6);
        assertArrayEquals(new int[] { 5, 14, 3, 12, 2, 11 }, result.getDegree());
        assertArrayEquals(new int[] { 3, 6, 2, 4, 1, 2 },
                result.getCoEfficient());

    }

}