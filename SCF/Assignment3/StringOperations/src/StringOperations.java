/**
 * 
 * @author Kunal
 * @desc : This class contains various functions that can be performed on a string
 */
public class StringOperations {
/**
 * 
 * @param str1
 * @param str2
 * @return 1 if strings are equal else 0
 */
	public static int compareStrings(String str1,String str2)
	{
		int returnVal = 1; 
		if(str1.length() != str2.length())
			returnVal = 0;
		else
	{		for(int index = 0 ; index < str1.length() ; index++ )
				{
				if( str1.charAt(index) != str2.charAt(index) )
				{
					returnVal = 0;
					break;
				}
				}
	}
		return returnVal;
	}
	/**
	 * 
	 * @param str
	 * @return reverse of the string passes as arguement
	 */
	public static String reverseString(String str)
	{
		String string = ""; // this var stores the reverse string
		char[] ch = new char[str.length()];
		   for ( int index=str.length()-1 ; index >= 0 ; index-- ){
		       ch[index] = str.charAt(str.length()-index-1);
		   }
		for( int index=0 ; index < str.length() ; index++ )
		{
		string = string + Character.toString(ch[index]);
		}
		return string;
	}
/**
 * 
 * @param str
 * @return changes the case of each alphabet in the string and then returns the result
 */
	public static String changeCase(String str)
	{
		String string = ""; // this variable contains the string after changing case of alphabets
		char[] ch = new char[str.length()];
		for ( int i = 0 ; i < str.length() ; i++ ) { // string into char array
		       ch[i] = str.charAt(i);
		   }
		   
		for( int index = 0; index < str.length() ; index++ ){
			if( ch[index] >= 'a' && ch[index] <= 'z')
			{
				ch[index] = (char)((int)ch[index] - 32);
			}
			else if( ch[index] >= 'A' && ch[index] <= 'Z')
			{
				ch[index] = (char)((int)ch[index] + 32);
			}
		string = string + Character.toString(ch[index]);
		}
	return string;
	}	
/**
 * 
 * @param s
 * @return the largest word present in the string
 */
	public static String largestWord(String s) {
		int space = 0; // space count in sentence
		for (int i = 0; i < s.length(); i++) { // counting space to identify no. of words
			if (s.charAt(i) == ' ')
				space++;
		}
		int length = 0; // length of largest word
		int largestWordIndex = 0; // stores index of largest word
		String words[] = new String[space + 1];
		String nstr = ""; // new String i.e; the new word we get
		for (int i = 0, j = 0; i < s.length(); i++) { // j := points to every new word in String s
			if (s.charAt(i) == ' ') {
				
				if (nstr.length() > length) {
					length = nstr.length();
					largestWordIndex = j;
				}
				words[j] = nstr; // storing each word in words[] array
				j++;
				nstr = "";
			} else {
				nstr = nstr + s.charAt(i);
			}
			words[j] = nstr;
		}
		return words[largestWordIndex];
	}
}
