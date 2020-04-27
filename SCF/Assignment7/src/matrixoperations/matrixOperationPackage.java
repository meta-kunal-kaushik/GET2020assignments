package matrixoperations;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * this class is to test all cases for class MatrixOperation using jUnit4
 * @author Kunal
 *
 */
public class matrixOperationPackage {
    /**
     * this function test the validity of matrixTranspose() 
     * @throws Exception ,if the matrix is null
     */
    @Test
    public void testTranspose() throws Exception {
        int input[][] = { { 0, 4, 9 }, { 1, 1, 0 }, { 0, 0, 4 }, { 0, 3, 0 },
                { 0, 0, 5 }, { 4, 0, 2 } };
        int transpose[][] = { { 0, 1, 0, 0, 0, 4 }, { 4, 1, 0, 3, 0, 0 },
                { 9, 0, 4, 0, 5, 2 } };
        MatrixOperation sm = new MatrixOperation(input);
        int result[][] = sm.matrixTranspose();
        assertArrayEquals(transpose, result);

    }

    /**
     * this function test the validity of symmetric() 
     * @throws Exception ,if the matrix is null
     */
    @Test
    public void testSymmetric() throws Exception {

        int input[][] = { { 0, 4, 9 }, { 1, 1, 8 }, { 2, 0, 4 }, { 2, 3, 2 },
                { 3, 5, 5 }, { 4, 2, 2 } };

        MatrixOperation sm = new MatrixOperation(input);
        assertEquals(false, sm.symmetric());

    }

    /**
     * this function test the validity of addMatrix() 
     * @throws Exception ,if the matrix is null
     */
    @Test
    public void testAddMetrices() throws Exception {

        int firstMatrix[][] = { { 0, 0, 1 }, { 1, 0, 0 }, { 0, 2, 0 } };

        int secondMatrix[][] = { { 0, 0, 2 }, { 0, 9, 3 }, { 1, 0, 0 } };

        int sumMatrix[][] = { { 0, 0, 3 }, { 1, 9, 3 }, { 1, 2, 0 } };
        MatrixOperation matrix1 = new MatrixOperation(firstMatrix);
        MatrixOperation matrix2 = new MatrixOperation(secondMatrix);
        assertArrayEquals(sumMatrix,
                MatrixOperation.addMatrix(matrix1, matrix2));

    }

    /**
     * this function test the validity of multiplyMatrix() 
     * @throws Exception ,if the matrix is null
     */
    @Test
    public void testMultiplyMetrices() throws Exception {

        int firstMatrix[][] = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };

        int secondMatrix[][] = { { 0, 0, 2 }, { 0, 1, 3 }, { 1, 2, 4 } };

        int mulMatrix[][] = { { 0, 0, 2 }, { 0, 1, 3 }, { 1, 2, 4 } };
        MatrixOperation matrix1 = new MatrixOperation(firstMatrix);
        MatrixOperation matrix2 = new MatrixOperation(secondMatrix);
        assertArrayEquals(mulMatrix,
                MatrixOperation.multiplyMatrix(matrix1, matrix2));

    }

    /**
     * this function represent the negative case i.e, when the matrix[][] is empty 
     * @throws Exception ,if the matrix is null
     */
    @Test
    public void testEmptyMatrix() {
        try {
            int matrix[][] = { {} };
            MatrixOperation matrix1 = new MatrixOperation(matrix);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
