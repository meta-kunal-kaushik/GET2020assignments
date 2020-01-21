package lcmHcf;
/**
 * this class performs two function using Recursion :
 *                               i)Lcm
 *                              ii)Hcf
 * @author Kunal
 *
 */
public class LcmHcf {
    /**
     * @desc This function takes two inputs and calculate their hcf
     * @param number1 ,int type
     * @param number2 ,int type
     * @return hcf of the above two numbers
     */
    public int hcf(int number1, int number2) {
        if (number2 != 0)
            return hcf(number2, number1 % number2);
        return number1;
    }
    /**
     * @desc Thos function takes two inputs and calculates their lcm
     * @param number1 ,int type
     * @param number2 ,int type
     * @return lcm of the above two numbers
     * @throws AssertionError i.e, if divide by zero occurs (if hcf=0)
     */
    public int lcm(int number1, int number2) throws AssertionError  
    {  
        if(number1==0 || number2 == 0)
            throw new AssertionError("divide by zero error");
       return (number1*number2)/hcf(number1, number2);  
    }  
}
