import java.util.Scanner;

/**
 * 
 * @author Kunal
 * @desc This class uses the predefined functions of class StringOperations to
 *       implement various tasks on strings
 */
public class StringOperationExecute {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String argv[]) {
		System.out.println("Enter a choice from below options : ");
		System.out.println("\n1. Compare two strings");
		System.out.println("2. Reverse a string");
		System.out
				.println("3. Change Lower to UpperCase and UpperCase to lowerCase");
		System.out.println("4. Find largest word in the string");
		System.out.println("5. Exit\n");
		// this var is used to ask user about the operation they want to perform from the above list
		int option = sc.nextInt();
		switch (option) {
		case 1: { // compare two strings
			System.out.println("Enter first string : ");
			sc.nextLine();
			String str1 = sc.nextLine();

			System.out.println("Enter second string : ");
			String str2 = sc.nextLine();
			System.out.println("Result : "
					+ StringOperations.compareStrings(str1, str2));
			break;
		}
		case 2: { // reverse a string
			System.out.println("Enter the string : ");
			sc.nextLine();
			String str = sc.nextLine();
			System.out.println("Result : " + StringOperations.reverseString(str));
			break;
		}
		case 3: { // change cases of each alphabet in the string
			System.out.println("Enter the string : ");
			sc.nextLine();
			String str = sc.nextLine();
			System.out.println("Result : " + StringOperations.changeCase(str));
			break;
		}
		case 4: { // find the largest word in the string
			System.out.println("Enter the string : ");
			sc.nextLine();
			String str = sc.nextLine();
			System.out.println("largest string : "
					+ StringOperations.largestWord(str));
			break;
		}
		case 5: { // Quit program
			System.out
					.println("Are you sure you want to exit(1) Or continue(0) ");
			int choice = sc.nextInt(); // this var asks for exit or not
			if (choice == 1)
				System.exit(0);
			else if (choice != 0) {
				System.out.println("Wrong choice made..\nPlease try later");
				System.exit(1);
			} else {
				System.out.println("Ok continue...\n");
			}
			break;
		}
		default: // Invalid choice
			System.out
					.println("Sorry !!, this choice is not present in the list...\n Try Again\n");
			break;
		}
	}
}
