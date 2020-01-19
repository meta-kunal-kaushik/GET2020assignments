/**
 * 
 * @author Kunal
 * @desc   this class contains functions including 
 * 1. countClump() 
 * 2. fixXY()
 * 3. splitArray()
 * 4. largestMirror()
 */
public class ArrOperation {
    /**
     * @desc Clump in an array is a series of 2 or more adjacent elements of the same value
     * @param array , int type
     * @return  number of clumps
     * @throws Exception , if array size is zero
     */
    public int countClump(int[] array) throws Exception {
        int count = 0; // number of clumps
        int index2; // for inner loop traverse
        int index1; // for outer loop traverse
        if (array.length == 0)
            throw new Exception("Array size is Zero");

        for (index1 = 0; index1 < array.length - 1; index1++) {
            if (array[index1] == array[index1 + 1]) {
                for (index2 = index1; index2 < array.length - 1; index2++) {
                    if (array[index2] != array[index2 + 1])
                        break;
                }
                index1 = index2;
                count++;
            }
        }
        return count;
    }

    /**
     * @desc Return an array that contains exactly the same numbers as the input array,
     *       but rearranged so that every X is immediately followed by a Y.
     *       Do not move X within array, but every other number may move.
     * @param array , int type
     * @return rearranged array with every 5 just after 4 
     * @throws Exception , if array size is zero or 4 is on last index or no. of 4 != no. of 5
     */
    public int[] fixXY(int[] array) throws Exception {
        int countIndexOf4 = 0; // number of 4 in array
        int countIndexOf5 = 0; // number of 5 in array
        if (array.length == 0)
            throw new Exception("array size is zero");
        if (array[array.length - 1] == 4)
            throw new Exception("4 is present on the last index");

        for (int index = 0; index < array.length; index++) { // count no. of 4 and 5 in array
            if (array[index] == 4)
                countIndexOf4++;
            if (array[index] == 5)
                countIndexOf5++;
        }

        if (countIndexOf5 != countIndexOf4)
            throw new Exception("count of 4 and 5 are not equal");
        int arrayOf4[] = new int[countIndexOf4];// arrayOf4[] stores the indexes where 4 is present
        int arrayOf5[] = new int[countIndexOf4];// arrayOf5[] stores the indexes where 5 is present

        int index1 = 0; // points to arrayOf4[]
        int index2 = 0; // points to arrayOf5[]
        for (int index = 0; index < array.length; index++) { // find and store index of 4 and 5 in respective arrays
            if (array[index] == 4)
                arrayOf4[index1++] = index;
            else if (array[index] == 5)
                arrayOf5[index2++] = index;
        }
        int intermideate; // a swapping variable
        for (int index = 0; index < countIndexOf4; index++) {
            intermideate = array[arrayOf4[index] + 1];
            array[arrayOf4[index] + 1] = array[arrayOf5[index]];
            array[arrayOf5[index]] = intermideate;
        }
        return array; 
    }

    /**
     * 
     * @param array ,int type array
     * @return Return the index if there is a place to split the input array so that the
     *         sum of the numbers on one side is equal to the sum of the numbers on the 
     *         other side else return -1.
     * @throws Exception , if array size is zero
     */
    public int splitArray(int[] array) throws Exception {
        int sum1 = 0;
        int sum2 = 0;
        int index2;
        int returnVal = -1; // if sum1 != sum2
        if (array.length == 0)
            throw new Exception("Array size is zero");
        for (int index1 = 0; index1 < array.length; index1++) {
            sum1 = sum2 = 0;
            for (index2 = 0; index2 <= index1; index2++) 
                sum1 += array[index2]; // sum from front face of array till index1
            for (int index3 = array.length - 1; index3 > index2 - 1; index3--)
                sum2 += array[index3]; // sum from back face of array from last element to index1
            if (sum1 == sum2) { // compare the sum1 and sum2
                returnVal = index2;
                break;
            }

        }
        return returnVal;
    }

    /**
     * @desc Mirror section in an array is a group of contiguous elements such that 
     *       somewhere in the array, the same group appears in reverse order.
     * @param array ,int type array
     * @return Return the size of the largest mirror section found in the input array.
     * @throws Exception , if array size is zero
     */
    public int largestMirror(int[] array) throws Exception {
        if (array.length == 0)
            throw new Exception("Array size is zero");
        int length = array.length; // stores array length

        int maxCount = 1; // to count the max. length of mirror
        boolean flag = false;

        for (int index1 = 0; index1 < length; index1++) {
            int tempCount = 1;
            int count = index1;

            for (int index2 = length - 1; index2 >= 0 && (count < length); index2--) {
                if (array[count] == array[index2] && !flag) {
                    flag = true;
                    count++;
                    continue;
                }
                if (array[count] == array[index2] && flag) {
                    tempCount++;
                    count++;
                    maxCount = (tempCount > maxCount) ? tempCount : maxCount; // update maxCount
                    continue;
                }
                if (array[index1] != array[index2] && flag) {
                    flag = false;
                    count = index1;
                    tempCount = 1;
                    continue;
                }
                if (index2 == count || (index2 - count) == 1) {
                    flag = false;
                    break;
                }

            }
        }
        return maxCount;
    }

}
