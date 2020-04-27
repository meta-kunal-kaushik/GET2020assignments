import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 
 * @author Kunal 
 * @desc : this class is to test all the functions of class
 *         ArrOperation using junit and also handling all assertion errors.
 */
public class TestArrOperation {

    /**
     * @desc : This function is to check all the test cases regarding
     * countClump() function
     */
    @Test
    public void testCountClump() {
        try {
            ArrOperation obj1 = new ArrOperation();
            int result = obj1.countClump(new int[] { 1, 2, 2, 3, 4, 4 });
            assertEquals(2, result); // assertEquals(expectedValue , resultFromCountClumpFunction)

            result = obj1.countClump(new int[] { 1, 1, 2, 1, 1 });
            assertEquals(2, result);

            result = obj1.countClump(new int[] { 1, 1, 1, 1, 1 });
            assertEquals(1, result);

            result = obj1.countClump(new int[] { 0, 0, 0, 0, 0 });
            assertEquals(1, result);
            // if input array is empty
            result = obj1.countClump(new int[] {});
            assertEquals(1, result);
        } catch (Exception ex) {
            System.out.println(" (countClumpTest) Exception : "
                    + ex.getMessage());
        }
    }

    /**
     * @desc : This function is to check all the test cases regarding fixXY()
     * function
     */
    @Test
    public void fixXYTest() {
        try {

            ArrOperation obj = new ArrOperation();
            int result[] = obj.fixXY(new int[] { 5, 4, 9, 4, 9, 5 });
            assertArrayEquals(new int[] { 9, 4, 5, 4, 5, 9 }, result); // assertArrayEquals(expectedArray , resultFromFixXYFunction)

            result = obj.fixXY(new int[] { 1, 4, 1, 5 });
            assertArrayEquals(new int[] { 1, 4, 5, 1 }, result);

            result = obj.fixXY(new int[] { 1, 4, 1, 5, 5, 4, 1 });
            assertArrayEquals(new int[] { 1, 4, 5, 1, 1, 4, 5 }, result);

            // if array is empty
            result = obj.fixXY(new int[] {});
            assertArrayEquals(new int[] { 1, 4, 5, 1, 1, 4, 5 }, result);
            // if 4 is present at last index
            result = obj.fixXY(new int[] { 4, 1, 5, 5, 4 });
            assertArrayEquals(new int[] { 1, 4, 5, 1, 1, 4, 5 }, result);
            // if no. of 4 is not equal to no. of 5
            result = obj.fixXY(new int[] { 1, 4, 6, 5, 5 });
            assertArrayEquals(new int[] { 1, 4, 5, 1, 1, 4, 5 }, result);

        } catch (Exception ex) {
            System.out.println("(fixXYTest) Exception : " + ex.getMessage());
        }

    }

    /**
     * @desc : This function is to check all the test cases regarding
     * splitArray() function
     */
    @Test
    public void splitArrayTest() {
        try {

            ArrOperation obj = new ArrOperation();
            int result = obj.splitArray(new int[] { 1, 1, 1, 2, 1 });
            assertEquals(3, result); // assertEquals(expectedValue , resultFromSplitArrayFunction)

            result = obj.splitArray(new int[] { 2, 1, 1, 2, 1 });
            assertEquals(-1, result);

            result = obj.splitArray(new int[] { 10, 10 });
            assertEquals(1, result);
            // if array is empty
            result = obj.splitArray(new int[] {});
            assertEquals(1, result);

        } catch (Exception ex) {
            System.out.println("(splitArrayTest) Exception : "
                    + ex.getMessage());
        }

    }

    /**
     * @desc : This function is to check all the test cases regarding
     * largestMirror() function
     */
    @Test
    public void largestMirrorTest() {
        try {

            ArrOperation obj = new ArrOperation();
            int result = obj
                    .largestMirror(new int[] { 1, 2, 3, 8, 9, 3, 2, 1 });
            assertEquals(3, result); // assertEquals(expectedValue , resultFromLargestMirrorFunction)

            result = obj.largestMirror(new int[] { 7, 1, 4, 9, 7, 4, 1 });
            assertEquals(2, result);

            result = obj.largestMirror(new int[] { 1, 2, 1, 4 });
            assertEquals(3, result);

            result = obj.largestMirror(new int[] { 1, 4, 5, 3, 5, 4, 1 });
            assertEquals(7, result);
            // if array is empty
            result = obj.largestMirror(new int[] {});
            assertEquals(7, result);
        } catch (Exception ex) {
            System.out.println("(largestMirrorTest) Exception : "
                    + ex.getMessage());
        }

    }
}
