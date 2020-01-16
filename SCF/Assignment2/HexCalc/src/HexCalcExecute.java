import java.util.Scanner;

/**
 * @author Kunal kaushik
 * @desc   : Class HexCalcExecute uses the functions which are  predefined in class HexCalc
 * to perform different operations on hexaDecimal numbers
 */
public class HexCalcExecute {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String argv[]) {
		int option; // this variable is to ask the user about what operation
					// they want to perform
		while (true) {

			HexCalc.showOption();// this function displays the list of operations that can be performed on hexaDecimal numbers
			try {
				option = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) // IF input is not a number
			{
				System.out.println("Wrong Input");
				System.out.println("Please enter your option again : ");
				option = Integer.parseInt(sc.nextLine());
			}
			switch (option) {

			case 1: // Addition of two hexaDecimal numbers
			{
				System.out.println("Enter the first number : ");
				String first = sc.nextLine(); // Input first hexaDecimal String
				System.out.println("Enter the second number : ");
				String second = sc.nextLine(); // Input second hexaDecimal String
				System.out.println(HexCalc.checkVaildString(first) + ""
						+ HexCalc.checkVaildString(second)); //string validation,i.e;hexaDecimal or not
				if (HexCalc.checkVaildString(first)
						&& HexCalc.checkVaildString(second))
					System.out.println("Addition is : "
							+ HexCalc.Add(first, second));
				else
					System.out.println("Wrong Input..\n");
				break;
			}
			case 2: // Subtraction of two hexaDecimal numbers
			{
				System.out.println("Enter the first number : ");
				String first = sc.nextLine(); // Input first hexaDecimal String
				System.out.println("Enter the second number : ");
				String second = sc.nextLine(); // Input second hexaDecimal String
				if (HexCalc.checkVaildString(first) //string validation,i.e;hexaDecimal or not
						&& HexCalc.checkVaildString(second))
					System.out.println("Subtraction is : "
							+ HexCalc.Subtract(first, second));
				else
					System.out.println("Wrong Input..\n");
				break;
			}
			case 3: // Division of two hexaDecimal numbers
			{
				System.out.println("Enter the first number : ");
				String first = sc.nextLine(); // Input first hexaDecimal String
				System.out.println("Enter the second number : ");
				String second = sc.nextLine(); // Input second hexaDecimal String
				if (HexCalc.checkVaildString(first)
						&& HexCalc.checkVaildString(second)) //string validation,i.e;hexaDecimal or not
					System.out.println("Division is : "
							+ HexCalc.Divide(first, second));
				else
					System.out.println("Wrong Input..\n");

				break;
			}
			case 4: // Multiplication of two hexaDecimal numbers
			{
				System.out.println("Enter the first number : ");
				String first = sc.nextLine(); // Input first hexaDecimal String
				System.out.println("Enter the second number : ");
				String second = sc.nextLine(); // Input second hexaDecimal String
				if (HexCalc.checkVaildString(first) //string validation,i.e;hexaDecimal or not
						&& HexCalc.checkVaildString(second))
					System.out.println("Multiplication is : "
							+ HexCalc.Multiply(first, second));
				else
					System.out.println("Wrong Input..\n");

				break;
			}
			case 5: // convert HexaDecimal number to decimal number
			{
				System.out.println("Enter the Hexa Decimal number : ");
				String hex = sc.nextLine(); // Input first hexaDecimal String
				if (HexCalc.checkVaildString(hex)) //string validation,i.e;hexaDecimal or not
					System.out.println("Hexa Decimal representation : "
							+ HexCalc.hexToDeci(hex)); // Input second hexaDecimal String
				else
					System.out.println("Wrong Input..\n");
				break;
			}
			case 6: // convert Decimal number to hexaDecimal number
			{
				System.out.println("Enter the Decimal number : ");
				int deci = Integer.parseInt(sc.nextLine()); 
				System.out.println("Hexa Decimal representation : "
						+ HexCalc.deciToHex(deci));
				break;
			}
			case 7: // Compare whether two hexaDecimal String are equal,greater than or less than one another
			{
				System.out.println("Enter the first number : ");
				String first = sc.nextLine();
				System.out.println("Enter the second number : ");
				String second = sc.nextLine();
				if (HexCalc.checkVaildString(first) //string validation,i.e;hexaDecimal or not
						&& HexCalc.checkVaildString(second)) {
					if (HexCalc.firstGreaterThenSecond(first, second)) {
						System.out.println(first + " > " + second);
					}

					else if (HexCalc.firstLessThenSecond(first, second)) {
						System.out.println(first + " < " + second);
					}

					else {
						System.out.println(first + " Equals to " + second);
					}
				} else
					System.out.println("Wrong Input...\n");
				break;
			}
			case 8: // Quit program
			{
				System.out
						.println("Are you sure you want to exit program :(y/n)");
				String choice = sc.nextLine();
				if (choice.equalsIgnoreCase("y")) {
					System.out.println("Exit Successful");
					System.exit(0);
				}

				else if (choice.equalsIgnoreCase("n")) {
					System.out.println("OK you can continue...\n");
				}

				else {
					System.out.println("Wrong input...\n");
				}

				break;
			}
			// if a wrong option which is not in the operation list then run default case
			default: {
				System.out
						.println("Sorry!!,this option is not mentioned in the above menu \n Please try again\n");
				break;
			}
			}
		}
	}
}
