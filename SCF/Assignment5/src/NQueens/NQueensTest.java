package NQueens;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * desc this class is to test the cases for NQueens class using jUnit
 * @author Kunal
 *
 */
public class NQueensTest {
    @Test
    public void testNQueens() {

        NQueens object = new NQueens();
        boolean result = object.solveNQueens(new int[][] { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } }, 0, 4);
        assertEquals(true, result);

        result = object.solveNQueens(new int[][] { { 0, 0, 0 }, { 0, 0, 0 },
                { 0, 0, 0 }, { 0, 0, 0 } }, 0, 3);
        assertEquals(false, result);

        result = object.solveNQueens(new int[][] {}, 0, 3);
        assertEquals(false, result);

    }

}
