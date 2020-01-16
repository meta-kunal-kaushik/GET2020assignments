/**
 * @author ${kunal kaushik}
 * @desc : This class can implement addition,subtraction,multiplication and division of hexaDecimal numbers
 * Also includes functions to change hexaDecimal to Decimal and vice-versa
 * 
 */
public class HexCalc {
	/**
	 * @author: kunal kaushik
	 * @desc: This function represents a set of options the user can choice as per needs
	 * @params: Not Needed
	 * @return: void
	 */
	public static void showOption()
	{
		System.out.println("Choose an option from given below : ");
		System.out.println("1. Add two Hexa Decimal numbers.");
		System.out.println("2. Subtract two Hexa Decimal numbers.");
		System.out.println("3. Divide two Hexa Decimal numbers.");
		System.out.println("4. Multiply two Hexa Decimal numbers.");
		System.out.println("5. Convert Hexa Decimal to Decimal number.");
		System.out.println("6. Convert Decimal to Hexa Decimal number.");
		System.out.println("7. Compare the two Hexa Decimal numbers.");
		System.out.println("8. Exit Program.");
	}
	
	/**
	 * @author: kunal kaushik
	 * @desc: This function can convert hexaDecimal number to decimal number
	 * @params: single String Input
	 * @return: int i.e,decimal equivalent
	 */
	public static int hexToDeci(String hex)
	{
		int deci=0;
		char ch;

		int base=1;
		for(int index=hex.length()-1;index>=0;index--)
		{
			ch=hex.charAt(index);
			if(ch>='A' && ch<='F')
				deci=deci+base*(int)(ch-55);
			else
				deci=deci+base*(int)(ch-48);
			base=base*16;
		}
		return deci;
	}
	
	/**
	 * @author: kunal kaushik
	 * @desc: This function can convert Decimal number to hexaDecimal number
	 * @params: single int Input
	 * @return: int i.e,HexaDecimal equivalent
	 */
	public static String deciToHex(int deci)
	{
		String hex="";
		int base=16;
		Integer rem;

		while(deci>0)
		{
			rem=deci%base;
			if(rem<10)
				hex = rem.toString() + hex;
			else if(rem>=10 && rem<=15)
				hex= (((char)(rem+55))+"").toString()+hex;
			deci=deci/base;
		}

		return hex;
	}
	
	/**
	 * @author: kunal kaushik
	 * @desc: This function adds two hexaDecimal number 
	 * @params: Two String parameters required,i.e,the numbers to be added
	 * @return: String i.e,output of Addition in hexadecimal
	 */
	public static String Add(String first,String second)
	{
		int f=HexCalc.hexToDeci(first);
		int s=HexCalc.hexToDeci(second);
		return HexCalc.deciToHex(f+s);
	}
	
	/**
	 * @author: kunal kaushik
	 * @desc: This function subtracts two hexaDecimal number 
	 * @params: Two String parameters required,i.e,the numbers to be subtracted
	 * @return: String i.e,output of Subtraction in hexadecimal
	 *
	 */
	public static String Subtract(String first,String second)
	{
		int f=HexCalc.hexToDeci(first);
		int s=HexCalc.hexToDeci(second);
		if(f>s)
			return HexCalc.deciToHex(f-s);
		else
			return HexCalc.deciToHex(s-f);	
	}
	
	/**
	 * @author: kunal kaushik
	 * @desc: This function performs division of two hexaDecimal number 
	 * @params: Two String parameters required,i.e,the numbers who participates in division
	 * @return: String i.e,output of division in hexadecimal
	 * Note: division is performed as (first/second),where first and second are the parameters shown below
	 */
	public static String Divide(String first,String second)
	{
		int f=HexCalc.hexToDeci(first);
		int s=HexCalc.hexToDeci(second);
		if(f/s>0)
			return HexCalc.deciToHex(f/s)+" ,remainder is "+f%s;
		else
			return "0 ,remainder is "+first;
	}
	
	/**
	 * @author: kunal kaushik
	 * @desc: This function multiply two hexaDecimal number 
	 * @params: Two String parameters required,i.e,the numbers to be multiplied
	 * @return: String i.e,output of multiplication in hexadecimal
	 */
	public static String Multiply(String first,String second)
	{

		int f=HexCalc.hexToDeci(first);
		int s=HexCalc.hexToDeci(second);
		return HexCalc.deciToHex(f*s);

	}

	/**
	 * @author: kunal kaushik
	 * @desc: This function Compares two hexaDecimal Strings  
	 * @params: Two String parameters required,i.e,the numbers to be compared
	 * @return: boolean value,i.e; if first > second return true else false
	 *             where first and second are @params
	 */
	public static boolean firstGreaterThenSecond( String first,String second) // Check first > second
	{

		if(first.length() > second.length())
			return true;
		for(int index=0;index<first.length();index++)
		{
			if(first.charAt(index)>second.charAt(index))
			{
				return true;
			}
		}
		return false;

	}

	/**
	 * @author: kunal kaushik
	 * @desc: This function Compares two hexaDecimal Strings  
	 * @params: Two String parameters required,i.e,the numbers to be compared
	 * @return: boolean value,i.e; if first < second return true else false
	 *             where first and second are @params
	 */
	public static boolean firstLessThenSecond( String first,String second) // Check first > second
	{

		if(first.length() < second.length())
			return true;
		for(int index=0;index<second.length();index++)
		{
			if(first.charAt(index)<second.charAt(index))
			{
				return true;
			}
		}
		return false;

	}

	/**
	 * @author: kunal kaushik
	 * @desc: This function Compares two hexaDecimal Strings  
	 * @params: Two String parameters required,i.e,the numbers to be compared
	 * @return: boolean value,i.e; if first = second return true else false
	 *             where first and second are @params
	 */
	public static boolean firstEqualsToSecond(String first,String second)//check first no is equal to secnod or not
	{
		if(first.equalsIgnoreCase(second))
			return true;
		else
			return false;
	}

	/**
	 * @author: kunal kaushik
	 * @desc: This function validates whether a string is hexaDecimal or not  
	 * @params: Single String parameters required
	 * @return: boolean value,i.e; if String is hexaDecimal returns true
	 *             else return false
	 */
	public static boolean checkVaildString(String string) //Check whether input string is valid Hexa Decimal String or not.
	{
		for(int index=0;index<string.length();index++)
		{
			if((string.charAt(index)>='0' && string.charAt(index) <='9') || (string.charAt(index)>='A' && string.charAt(index) <='F'))
			{
				continue;
			}
			else
				return false;
		}
		return true;
	}

}
