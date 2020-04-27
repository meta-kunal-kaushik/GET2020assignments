package Search;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * @desc this class checks the test cases for i) LinearSearch ii) BinarySearch using jUnit
 * @author Kunal
 *
 */
public class TestSearch {
    @Test
    /**
     * @desc this functions checks for validity for LinearSearch
     */
    public void testLinearSearch() {
        try {

            Search object = new Search();
            int result;

            result = object.linearSearchImplement(new int[] { 1, 2, 3, 4, 5, 6,
                    7, 8 }, 8);
            assertEquals(8, result);

            result = object.linearSearchImplement(new int[] { 4, 5, 6, 7, 8 },
                    1);
            assertEquals(-1, result);

            result = object.linearSearchImplement(new int[] { 3, 5, 1, 2, 6 },
                    2);
            assertEquals(4, result);

            result = object.linearSearchImplement(new int[] {}, 8);
            assertEquals(1, result);
        } catch (AssertionError ex) {
            System.out.println("(testLinearSearch) AssertionError : "
                    + ex.getMessage());
        }
    }
    /**
     * @desc this functions checks for validity for BinarySearch
     */
    @Test
    public void testBinarySearch() {
        try {

            Search object = new Search();
            int result;

            result = object.binarySearchImplement(new int[] { 1, 2, 3, 4, 5, 6,
                    7, 8 }, 8);
            assertEquals(8, result);

            result = object.binarySearchImplement(new int[] { 4, 5, 6, 7, 8 },
                    1);
            assertEquals(-1, result);

            result = object.binarySearchImplement(new int[] {}, 8);
            assertEquals(1, result);
        } catch (AssertionError ex) {
            System.out.println("(testBinarySearch) AssertionError : "
                    + ex.getMessage());
        }
    }
}
