package polynomial;

/**
 * @desc Implement the immutable class Polynomial using an array to represent
 *       single variable polynomial. Note that you should be storing only those
 *       terms of polynomial that have non zero coefficient. You can assume that
 *       the coefficients are integers
 * 
 *       It should support methods like -
 * 
 *       i)evaluate(float) - return the value of the polynomial for the given
 *       value of the variable
 * 
 *       ii)degree() - return the degree of the polynomial
 * 
 *       iii)addPoly(Poly p1, Poly p2) - return the sum of the polynomials p1
 *       and p2
 * 
 *       iv)multiplyPoly(Poly p1, Poly p2) - return the product of polynomials
 *       p1 and p2
 * 
 * @author Kunal
 *
 */
final public class Polynomial {
    private final int[] degree; // stores degree of each variable in the
                                // polynomial
    private final int[] coEfficient; // stores the coEfficients present before
                                     // each variable in a polynomial

    public Polynomial(int[] degree, int[] coEfficient) {

        this.degree = degree;
        this.coEfficient = coEfficient;
    }

    /**
     * @desc this function evalutes the polynomial expression for the given
     *       value
     * @param value
     * @return returns an integer value i.e, the result of the polynomial
     */
    public int evaluate(int value) {
        int returnVal = 0;
        int tempResult;// stores result of each variable evaluation like in
                       // 2X^3+X , it stores result for X^3 and X separately
        for (int index1 = 0; index1 < coEfficient.length; index1++) {
            tempResult = 1;
            for (int index2 = 0; index2 < degree[index1]; index2++)
                tempResult *= value;

            returnVal += tempResult * coEfficient[index1];
        }
        return returnVal;
    }

    /**
     * 
     * @return this function returns the degree array of current polynomial
     */
    public int[] getDegree() {
        return this.degree;
    }

    /**
     * 
     * @return this function returns the coEfficient array of the current
     *         polynomial
     */
    public int[] getCoEfficient() {
        return this.coEfficient;
    }

    /**
     * @desc this function finds the maximum degree present in the polynomial
     * @return maximun degree in the polynomial
     */
    public int degree() {
        int returnVal = 0;
        for (int index = 0; index < this.degree.length; index++) {
            if (this.degree[index] > returnVal)
                returnVal = this.degree[index];
        }
        return returnVal;
    }

    /**
     * @desc adds two polynomial
     * @param poly1
     * @param poly2
     * @return the addition of the above two polynomials
     */
    public static Polynomial addPoly(Polynomial poly1, Polynomial poly2) {
        int setSize; // to set the size of result polynomial 
        if (poly1.degree.length > poly2.degree.length)
            setSize = poly1.degree.length;
        else
            setSize = poly2.degree.length;
        Polynomial poly3 = new Polynomial(new int[setSize], new int[setSize]);
        int sum;
        boolean flag = false;
        int tempDegree = 0;
        int index1 = 0;
        for (int index2 = 0; index2 < poly1.degree.length; index2++) {
            sum = 0;
            flag = false;
            // check for degree match
            for (int index3 = 0; index3 < poly2.degree.length; index3++) {
                if (poly1.degree[index2] == poly2.degree[index3]) {
                    sum += poly1.coEfficient[index2]
                            + poly2.coEfficient[index3];
                    flag = true;
                    tempDegree = poly1.degree[index2];
                    break;
                }
            }

            if (flag == true) {// degree match found
                poly3.degree[index1] = tempDegree;
                poly3.coEfficient[index1] = sum;
            } else { // put elements of poly1 whose degree is not in poly2
                poly3.degree[index1] = poly1.degree[index2];
                poly3.coEfficient[index1] = poly1.coEfficient[index2];
            }
            index1++;

        }
        // put elements of poly2 whose degree is not in poly1
        for (int index2 = 0; index2 < poly2.degree.length; index2++) {
            flag = false;
            // check for degree match
            for (int index3 = 0; index3 < poly1.degree.length; index3++) {
                if (poly2.degree[index2] == poly1.degree[index3]) {
                    {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag == false) {// no degree match found for poly2 then add it
                                // in poly3
                poly3.degree[index1] = poly2.degree[index2];
                poly3.coEfficient[index1] = poly2.coEfficient[index2];
            }
            index1++;

        }
        return poly3;

    }

    public static Polynomial multiplyPoly(Polynomial poly1, Polynomial poly2) {
        int size = poly1.degree.length * poly2.degree.length;
        Polynomial poly3 = new Polynomial(new int[size], new int[size]); 
        int index = 0; // to traverse degree array and coEfficient array
        for (int index1 = 0; index1 < poly1.degree.length; index1++) {
            for (int index2 = 0; index2 < poly2.degree.length; index2++) {
                poly3.degree[index] = poly1.degree[index1]
                        + poly2.degree[index2];
                poly3.coEfficient[index] = poly1.coEfficient[index1]
                        * poly2.coEfficient[index2];
                index++;
            }
        }

        int countUniqueDegrees = 0; // stores the unique elements present in poly3
        int index4;
        for (index4 = 0; index4 < poly3.degree.length - 1; index4++) { // count unique elements in user array
            if (poly3.degree[index4] != poly3.degree[index4 + 1])
                countUniqueDegrees++;
        }
        if (poly3.degree[index4] != poly3.degree[index4 - 1])
            countUniqueDegrees++;

        int counter = 0;
        int index1;
        Polynomial poly4 = new Polynomial(new int[countUniqueDegrees], // resultant Polynomial
                new int[countUniqueDegrees]);
        for (index1 = 0; index1 < poly3.degree.length - 1; index1++) {
            if (poly3.degree[index1] != poly3.degree[index1 + 1]) {// store unique elements
                poly4.degree[counter] = poly3.degree[index1];
                poly4.coEfficient[counter] = poly3.coEfficient[index1];
                counter++;
            }
        }
        if (poly3.degree[index1] != poly3.degree[index1 - 1]) {
            poly4.degree[counter] = poly3.degree[index1];
            poly4.coEfficient[counter] = poly3.coEfficient[index1];
        }
        return poly4;
    }
}
