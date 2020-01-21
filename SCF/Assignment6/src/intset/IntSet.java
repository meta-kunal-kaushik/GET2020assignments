package intset;

import java.util.Arrays;
/**
 * @desc Implement the immutable class intSet using an array to represent a set of
 * integers in the range 1-1000. It should support public methods like -
 * 
 * i)isMember(int x) - check whether x is a member of the set and return a boolean
 * value
 * 
 * ii)size() - return the size of the set
 * 
 * iii)isSubSet(intSet s) - check whether s is a subset of the set
 * 
 * iv)getComplement() - return the complement set, you can assume that 1..1000 is
 * the universal set
 * 
 * v)union(intSet s1, intSet s2) - return the union of s1 and s2
 * 
 * @author Kunal
 *
 */
final public class IntSet {
    final int set[]; // this array will store the unique elements from the array provided by the user

    /**
     * @desc this is a parameterized constructor which finds the unique elements from the array provided by the user and then stores it into set[]
     * @param array ,int type array
     * @throws Exception ,if array size is zero
     */
    public IntSet(int[] array) throws Exception {//constructor
        if (array.length == 0)
            throw new Exception("Array size is Zero");
        Arrays.sort(array);// sort user array
        int setArraySize = 0;
        int index;// to traverse in for loop
        int counter = 0; // to traverse index or set[] array
        for (index = 0; index < array.length - 1; index++) { // count unique elements in user array
            if (array[index] != array[index + 1])
                setArraySize++;
        }
        if (array[index] != array[index - 1])
            setArraySize++;
        this.set = new int[setArraySize]; // make an array of size setArraySize
        for (index = 0; index < array.length - 1; index++) { //storing unique elements in the set[]
            if (array[index] != array[index + 1])
                set[counter++] = array[index];
        }
        if (array[index] != array[index - 1])
            set[counter] = array[index];
    }

    /**
     * @desc checks whether a value belongs to the set[] or not
     * @param searchValue , int type
     * @return boolean value i.e, if searchValue is present in set[] return true else false
     */
    boolean isMember(int searchValue) { 
        boolean returnVal = false; // if searchValue is not present in set[]
        for (int index = 0; index < set.length; index++) {
            if (set[index] == searchValue) {
                returnVal = true; // if searchValue is present in the set[]
                break;
            }
        }
        return returnVal;
    }

    /**
     * @desc this function returns the size of the set[]
     * @return this function returns the size of the set[]
     */
    int size() {
        return set.length; // returns the size of the set[]
    }

    /**
     * @desc checks whether a  set passed as a arguement is a subset of other set or not
     * @param object ,InSet type
     * @return boolean value i.e, is object.set[] is a subset return true else false
     */
    public boolean isSubSet(IntSet object) {
        boolean flag = true; // true if object.set[] is a subset of set[]
        for (int index1 = 0; index1 < this.set.length; index1++) {
            for (int index2 = 0; index2 < object.set.length; index2++) {
                if (!this.isMember(object.set[index2])) {
                    flag = false;
                    return flag; // if object.set[] is not a subset of set[]
                 }
            }
        }
        return flag;
    }

    /**
     * @desc this function simply does union of two sets
     * @param set1, IntSet type
     * @param set2, IntSet type
     * @return array which contains union of set1 & set2
     */
    public int[] union(IntSet set1, IntSet set2) {
        int resultArray[]; //stores the union array i.e (set1 U set2)
        int countTotalValues = set1.set.length; // stores total number of unique elements present in both set1 and set2
        for (int index1 = 0; index1 < set1.set.length; index1++) {
            if (!set1.isMember(set2.set[index1]))
                countTotalValues++;

        }
        countTotalValues++;
        resultArray = new int[countTotalValues]; // declare array of size countTotalValues
        for (int index1 = 0; index1 < countTotalValues; index1++) { // storing the unique elements of set1 and set2 in resultArray[]
            if (index1 < set1.set.length)
                resultArray[index1] = set1.set[index1];
            else if (!set1.isMember(set2.set[index1 - set1.set.length]))
                resultArray[index1] = set2.set[index1 - set1.set.length];

        }
        return resultArray;
    }

    /**
     * @desc this function simply does complement of the current set
     * @return the complemented array (int type) 
     */
    public int[] getComplement() {
        int returnArraySize = 1000 - set.length; // complementSize = unionSize - setSize;
        int counter = 0; // to traverse index of returnArray
        int returnArray[] = new int[returnArraySize]; 

        for (int index = 1; index <= 1000; index++) {
            if (!this.isMember(index)) // if any element from 1 to 1000 is not in set[] then add it to resultArray i.e, complement array
                returnArray[counter++] = index;
        }
        return returnArray;
    }
}
