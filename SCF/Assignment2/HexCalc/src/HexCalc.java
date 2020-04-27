/**
 * @author Kunal
 * @desc : This class can implement addition,subtraction,multiplication and
 *       division of hexaDecimal numbers Also includes functions to change
 *       hexaDecimal to Decimal and vice-versa
 * 
 */
public class HexCalc {

	/**
	 * @desc: This function can convert hexaDecimal number to decimal number
	 * @param hex
	 * @return int type i.e,decimal equivalent
	 */
	public static int hexToDeci(String hex) {
		int deci = 0;
		char ch;

		int base = 1;
		for (int index = hex.length() - 1; index >= 0; index--) {
			ch = hex.charAt(index);
			if (ch >= 'A' && ch <= 'F')
				deci = deci + base * (int) (ch - 55);
			else
				deci = deci + base * (int) (ch - 48);
			base = base * 16;
		}
		return deci;
	}

	/**
	 * @desc: This function can convert Decimal number to hexaDecimal number 
	 * @param deci
	 * @return  int i.e,HexaDecimal equivalent
	 */
	public static String deciToHex(int deci) {
		String hex = "";
		int base = 16;
		Integer rem;

		while (deci > 0) {
			rem = deci % base;
			if (rem < 10)
				hex = rem.toString() + hex;
			else if (rem >= 10 && rem <= 15)
				hex = (((char) (rem + 55)) + "").toString() + hex;
			deci = deci / base;
		}

		return hex;
	}

	/**
	 * @desc: This function adds two hexaDecimal number
	 * @param first , String type
	 * @param second , String type
	 * @return String i.e,output of Addition in hexadecimal
	 */
	public static String add(String first, String second) {
		int first_ = HexCalc.hexToDeci(first);
		int second_ = HexCalc.hexToDeci(second);
		return HexCalc.deciToHex(first_ + second_);
	}

	/**
	 * @desc: This function subtracts two hexaDecimal number 
	 * @param first ,String type
	 * @param second ,String type
	 * @return String i.e,output of Subtraction in hexadecimal
	 */
	public static String subtract(String first, String second) {
		int first_ = HexCalc.hexToDeci(first);
		int second_ = HexCalc.hexToDeci(second);
		if (first_ > second_)
			return HexCalc.deciToHex(first_ - second_);
		else
			return HexCalc.deciToHex(second_ - first_);
	}

	/**
	 * 
	 * @param first ,String type
	 * @param second ,String type
	 * @return  String i.e,output of division in hexadecimal 
	 * 			Note: division is performed as (first/second),where first and second are the
	 *          parameters shown below
	 */
	public static String divide(String first, String second) {
		int first_ = HexCalc.hexToDeci(first);
		int second_ = HexCalc.hexToDeci(second);
		if (first_ / second_ > 0)
			return HexCalc.deciToHex(first_ / second_) + " ,remainder is "
					+ first_ % second_;
		else
			return "0 ,remainder is " + first;
	}
/**
	 * @desc: This function multiply two hexaDecimal number
	 * @param first ,String type
	 * @param second ,String type
	 * @return String i.e,output of multiplication in hexadecimal
	 */
	public static String multiply(String first, String second) {

		int first_ = HexCalc.hexToDeci(first);
		int second_ = HexCalc.hexToDeci(second);
		return HexCalc.deciToHex(first_ * second_);

	}

	/**
	 * 
	 * @param first ,String type
	 * @param second ,String type
	 * @return  boolean value,i.e; if first > second return true else false
	 */
	public static boolean firstGreaterThenSecond(String first, String second) {
		boolean returnVal = false;
		if (first.length() > second.length())
			returnVal = true;
		for (int index = 0; index < first.length(); index++) {
			if (first.charAt(index) > second.charAt(index)) {
				returnVal = true;
			}
		}
		return returnVal;

	}

	/**
	 * @desc: This function Compares two hexaDecimal Strings 
	 * @param first ,String type
	 * @param second ,String type
	 * @return  boolean value,i.e; if first < second return true else false
	 */
	public static boolean firstLessThenSecond(String first, String second) {
		boolean returnVal = false;
		if (first.length() < second.length())
			returnVal = true;
		for (int index = 0; index < second.length(); index++) {
			if (first.charAt(index) < second.charAt(index)) {
				returnVal = true;
			}
		}
		return returnVal;

	}

	/**
	 * 
	 * @param first ,String type
	 * @param second ,String type
	 * @return boolean value,i.e; if first = second return true else false
	 */
	public static boolean firstEqualsToSecond(String first, String second) {
		boolean returnVal = false;
		if (first.equalsIgnoreCase(second))
			returnVal = true;
		return returnVal;
	}

	/**
	 * @desc: This function validates whether a string is hexaDecimal or not
	 * @param string ,String type
	 * @return
	 */
	public static boolean checkVaildString(String string) {
		boolean returnVal = true;
		for (int index = 0; index < string.length(); index++) {
			if ((string.charAt(index) >= '0' && string.charAt(index) <= '9')
					|| (string.charAt(index) >= 'A' && string.charAt(index) <= 'F')) {
				continue;
			} else
				returnVal = false;
		}
		return returnVal;
	}

}
