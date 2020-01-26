package matrixoperations;
/**
 * @desc this class performs basic operations on a matrix i.e, add , transpose , multiply and symmetric or not
 * This class uses a single class variable i.e, matrix[][3];
 * where, for any index i
 *       matrix[i][0] = row no.,
 *       matrix[i][1] = col. no.,
 *       matrix[i][2] = value at (row,col)
 * @author Kunal
 *
 */
public final class MatrixOperation {
    private final int[][] matrix; 

    public MatrixOperation(int[][] sparse) throws Exception {
        int count = 0; // stores the number of non zero elements in sparse
                       // matrix
        if (sparse == null) {
            throw (new Exception(" NUll Value Array Passed"));
        }
        for (int row = 0; row < sparse.length; row++) {
            for (int column = 0; column < sparse[0].length; column++) {
                if (sparse[row][column] != 0) {
                    count++; // count no. of non zero elements

                }
            }
        }

        matrix = new int[count][3];
        count = 0;
        for (int row = 0; row < sparse.length; row++) {
            for (int column = 0; column < sparse[0].length; column++) {
                if (sparse[row][column] != 0) { // storing non zero elements with their row and column
                    matrix[count][0] = row;
                    matrix[count][1] = column;
                    matrix[count][2] = sparse[row][column];
                    count++;
                }
            }
        }
    }

    /**
     * 
     * @return this function returns the max. no of column present in the matrix
     */
    private int max() {
        int columnLength = 0; // stores the total no. of columns present in the matrix
        for (int index = 0; index < matrix.length; index++) {
            if (matrix[index][1] > columnLength) {
                columnLength = matrix[index][1];
            }
        }
        return columnLength;
    }

    /**
     * 
     * @return this function returns an Integer array which is the transpose of the array with which the function is called
     */
    public int[][] matrixTranspose() {
        int transposedMatrix[][];
        int index = 0; // to traverse the matrix[][] array
        transposedMatrix = new int[max() + 1][(matrix[matrix.length - 1][0] + 1)];
        System.out.println("row : " + transposedMatrix[0].length + "col : "
                + transposedMatrix.length);
        for (int row = 0; row < transposedMatrix[0].length; row++)
            for (int column = 0; column < transposedMatrix.length; column++) {
                if (matrix[index][0] == row && matrix[index][1] == column) { // if row and column is present in matrix[][] array then do transpose

                    transposedMatrix[column][row] = matrix[index][2];
                    index++;
                } else
                    transposedMatrix[column][row] = 0; // if row and column is not in matrix i.e, that place has zero then store 0 
            }
        return transposedMatrix;
    }

    /**
     * 
     * @return this function returns the boolean variable i.e, if a matrix is symmetric then return true else false
     */
    public boolean symmetric() {
        int transposedMatrix[][] = matrixTranspose();

        int index = -1;
        if (transposedMatrix.length != matrix[matrix.length - 1][0] + 1) 
            return false;
        else
            for (int row = 0; row < transposedMatrix.length; row++)
                for (int column = 0; column < (transposedMatrix[0].length); column++) {
                    index++;
                    if (row == matrix[index][0]
                            && column == matrix[index][1]
                            && transposedMatrix[row][column] != matrix[index][2])
                        return false; //if the transpose matrix is not similar to original matrix at any row,column return false
                }
        return true;
    }

    /**
     * 
     * @return this function returns an array containing two elements i.e, {no.of rows , no.of columns}
     */
    public int[] size() {
        return new int[] { (matrix[matrix.length - 1][0] + 1), max() + 1 }; //returns {no.of rows , no.of columns}
    }

    static int[][] addMatrix(MatrixOperation m1, MatrixOperation m2)
            throws Exception {
        if (m1 == null || m2 == null) // if any of the matrix is empty
            throw new Exception(" NUll Value Object Passed");
        int size1[] = m1.size(), size2[] = m2.size();
        if (size1[0] != size2[0] || size1[1] != size2[1]) { //if dimensions of two matrix are not same
            throw new Exception(
                    " both matrix are of different size can't perform addition operation ");
        }
        int add[][] = new int[size1[0]][size1[1]];
        for (int row = 0; row < size1[0]; row++)
            for (int column = 0; column < size1[1]; column++) {
                add[row][column] = m1.getValue(new int[] { row, column })
                        + m2.getValue(new int[] { row, column });
            }
        return add;
    }

    /**
     * 
     * @param index ,Integer array
     * @return this function returns the value at the specified row,column in matrix[][]
     */
    private int getValue(int index[]) {
        for (int index1 = 0; index1 < matrix.length; index1++)
            if ((matrix[index1][0]) == index[0]
                    && (matrix[index1][1]) == index[1]) // check if row,column is in matrix[][] or not
                return matrix[index1][2]; // if yes return its value;
        return 0;
    }

    /**
     * 
     * @param matrix1 ,Integer type array
     * @param matrix2 ,Integer type array
     * @return this function returns the multiplication of the above two matrices
     * @throws Exception ,if there is null array or size mismatch
     */
    public static int[][] multiplyMatrix(MatrixOperation matrix1,
            MatrixOperation matrix2) throws Exception {
        if (matrix1 == null || matrix2 == null)
            throw new Exception(" NUll Value Object Passed");
        int sizeOfMatrix1[] = matrix1.size(), sizeOfMatrix2[] = matrix2.size();
        if (sizeOfMatrix1[1] != sizeOfMatrix2[0]) {
            throw new Exception(" Multiplication Can't be performed ");
        }
        int multiply[][] = new int[sizeOfMatrix1[0]][sizeOfMatrix2[1]]; // stores the final result
        for (int row = 0; row < sizeOfMatrix1[0]; row++)
            for (int column = 0; column < sizeOfMatrix2[1]; column++) {
                multiply[row][column] = 0;
                for (int index = 0; index < sizeOfMatrix1[1]; index++) {
                    multiply[row][column] += matrix1.getValue(new int[] { row,
                            index })
                            * matrix2.getValue(new int[] { index, column });
                }
            }
        return multiply;
    }
}