package Search;
/**
 * @desc this class implements i) LinearSearch ii) BinarySearch using recursion
 * @author Kunal
 *
 */
public class Search {
    /**
     * 
     * @param array,int type array
     * @param searchForThis ,int type
     * @return if element is present then return its index else return -1
     * @throws AssertionError ,if Array size is zero
     */
    public int binarySearchImplement(int [] array,int searchForThis) throws AssertionError
    {
        if(array.length ==0)
            throw new AssertionError("Array size is Zero");
        return binarySearchAlgo(array,searchForThis,0,array.length-1);
    }
    /**
     * 
     * @param array ,int type array
     * @param searchForThis ,int type
     * @param first ,int type
     * @param last ,int type
     * @return if element is present then return its index else return -1
     */
    public int binarySearchAlgo(int [] array,int searchForThis ,int first ,int last)
    {
        int mid =(first+last)/2; //first : start index of array & last : last index of array
        if(first>last)
            return -1; // if element is not present in array
        else if(array[mid] == searchForThis)
            return mid+1;
        else if(searchForThis > array[mid])
            {
            first=mid+1;
            return binarySearchAlgo(array,searchForThis,first,last);
            }
        else
        {
            last = mid-1;
            return binarySearchAlgo(array,searchForThis,first,last);
        }
    }

    /**
     * 
     * @param array ,int type array
     * @param searchForThis ,int type
     * @return if element is present then return its index else return -1
     * @throws AssertionError ,if array length is Zero
     */
    public int linearSearchImplement(int [] array,int searchForThis) throws AssertionError
    {
        if(array.length ==0)
            throw new AssertionError("Array size is Zero");
        int index=0;
        return linearSearchAlgo(array,searchForThis,index);
    }
    /**
     * 
     * @param array ,int type array
     * @param searchForThis ,int type
     * @param index ,int type
     * @return if element is present then return its index else return -1
     */
    public int linearSearchAlgo(int [] array,int searchForThis,int index)
    {
        if(index>array.length-1)
            return -1; // if element is not present in array
        else if(array[index]==searchForThis)
            return index+1;
        else
            return linearSearchAlgo(array,searchForThis,++index);
    }
}
