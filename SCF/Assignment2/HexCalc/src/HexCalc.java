import java.util.Scanner;
/*
 * @author ${kunal kaushik}
 * 
 */
public class HexCalc {
	
	private static Scanner sc=new Scanner(System.in);
	public static void main(String argv[]) 
	{
		int option;
		
		
		while(true)
		{
			
			HexCalc.Choose_option();
		try
		{
			option = Integer.parseInt(sc.nextLine());
		}	
		catch(NumberFormatException e) // IF input is not a number
		{
			System.out.println("Wrong Input");
			System.out.println("Please enter your option again : ");
			option = Integer.parseInt(sc.nextLine());
		}
			switch(option)
			{
			
				case 1: // Add 2 hexa no.
					{
						System.out.println("Enter the First number : ");
						String First = sc.nextLine();
						
						System.out.println("Enter the Second number : ");
						
						String Second = sc.nextLine();
						System.out.println(HexCalc.checkVaildString(First) +""+HexCalc.checkVaildString(Second));
						if(HexCalc.checkVaildString(First) && HexCalc.checkVaildString(Second))
						System.out.println("Addition is : "+HexCalc.Add(First,Second));
						else
							System.out.println("Wrong Input..\n");
						break;
					}
				case 2: // Subtract 2 hexa no.
					{
						System.out.println("Enter the First number : ");
						String First = sc.nextLine();
						System.out.println("Enter the Second number : ");
						String Second = sc.nextLine();
						if(HexCalc.checkVaildString(First) && HexCalc.checkVaildString(Second))
						System.out.println("Subtraction is : "+HexCalc.Subtract(First,Second));
						else
							System.out.println("Wrong Input..\n");
						break;
					}
				case 3: // Divide 2 hexa no.
					{
						System.out.println("Enter the First number : ");
						String First = sc.nextLine();
						System.out.println("Enter the Second number : ");
						String Second = sc.nextLine();
						if(HexCalc.checkVaildString(First) && HexCalc.checkVaildString(Second))
						System.out.println("Division is : "+HexCalc.Divide(First,Second));
						else
							System.out.println("Wrong Input..\n");
						
						break;
					}
				case 4: // Multiply 2 hexa no.
					{
						System.out.println("Enter the First number : ");
						String First = sc.nextLine();
						System.out.println("Enter the Second number : ");
						String Second = sc.nextLine();
						if(HexCalc.checkVaildString(First) && HexCalc.checkVaildString(Second))
						System.out.println("Multiplication is : "+HexCalc.Multiply(First,Second));
						else
							System.out.println("Wrong Input..\n");
						
						break;
					}
				case 5: // Hexa to deci
					{
						System.out.println("Enter the Hexa Decimal number : ");
						String hex=sc.nextLine();
						if(HexCalc.checkVaildString(hex))
						System.out.println("Hexa Decimal representation : "+HexCalc.Hex_to_deci(hex));
						else
							System.out.println("Wrong Input..\n");
						break;
					}
				case 6: // Deci to hexa
					{
						System.out.println("Enter the Decimal number : ");
						int deci = Integer.parseInt(sc.nextLine());
						System.out.println("Hexa Decimal representation : "+HexCalc.Deci_to_hex(deci));
						break;
					}
				case 7: // Compare two hexa
					{
						System.out.println("Enter the First number : ");
						String First = sc.nextLine();
						System.out.println("Enter the Second number : ");
						String Second= sc.nextLine();
						if(HexCalc.checkVaildString(First) && HexCalc.checkVaildString(Second))
						{	
						if(F_gt_S(First,Second))
						{
							System.out.println(First+" > "+Second);
						}
						
						else if(F_lt_S(First,Second))
						{
							System.out.println(First+" < "+Second);
						}
						
						else
						{
							System.out.println(First+" Equals to "+Second);
						}
						}
						else
							System.out.println("Wrong Input...\n");
						break;
					}
				case 8: // Quit
					{
						System.out.println("Are you sure you want to exit program :(y/n)");
						String choice=sc.nextLine();
						if(choice.equalsIgnoreCase("y"))
						{
							System.out.println("Exit Successful");
							System.exit(0);
						}
						
						else if(choice.equalsIgnoreCase("n"))
						{
							System.out.println("OK you can continue...\n");
						}
						
						else
						{
							System.out.println("Wrong input...\n");
						}
						
						break;
					}
				default:
					{
						System.out.println("Sorry!!,this option is not mentioned in the above menu \n Please try again\n");
						break;
					}
			
			}
			
			
			
			
		//	sc.close();	
		}
		
		
	}
	
	public static void Choose_option()
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

	public static int Hex_to_deci(String hex)
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
	
	public static String Deci_to_hex(int deci)
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
	
	public static String Add(String First,String Second)
	{
		int f=HexCalc.Hex_to_deci(First);
		int s=HexCalc.Hex_to_deci(Second);
		return HexCalc.Deci_to_hex(f+s);
	}
	
	public static String Subtract(String First,String Second)
	{
		int f=HexCalc.Hex_to_deci(First);
		int s=HexCalc.Hex_to_deci(Second);
		if(f>s)
			return HexCalc.Deci_to_hex(f-s);
		else
			return HexCalc.Deci_to_hex(s-f);	
	}
	
	public static String Divide(String First,String Second)
	{
		int f=HexCalc.Hex_to_deci(First);
		int s=HexCalc.Hex_to_deci(Second);
		if(f/s>0)
		return HexCalc.Deci_to_hex(f/s)+" ,remainder is "+f%s;
		else
			return "0 ,remainder is "+First;
	}
	
	public static String Multiply(String First,String Second)
	{

		int f=HexCalc.Hex_to_deci(First);
		int s=HexCalc.Hex_to_deci(Second);
		return HexCalc.Deci_to_hex(f*s);
		
	}
	public static boolean F_gt_S( String First,String Second) // Check First > Second
	{
		
	if(First.length() > Second.length())
		return true;
	for(int index=0;index<First.length();index++)
	{
		if(First.charAt(index)>Second.charAt(index))
		{
			return true;
		}
	}
	return false;
	
	}

	public static boolean F_lt_S( String First,String Second) // Check First > Second
	{
		
	if(First.length() < Second.length())
		return true;
	for(int index=0;index<Second.length();index++)
	{
		if(First.charAt(index)<Second.charAt(index))
		{
			return true;
		}
	}
	return false;
	
	}
	
	public static boolean F_eq_S(String First,String Second)//check First no is equal to secnod or not
	{
		if(First.equalsIgnoreCase(Second))
			return true;
		else
			return false;
	}
	
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
