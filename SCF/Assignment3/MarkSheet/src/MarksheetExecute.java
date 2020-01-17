import java.util.Scanner;
/**
 * 
 * @author Kunal
 * @desc  This class MarksheetExecute uses predefined functions of class Marksheet
 * to perform various operations on student grades. 
 */
public class MarksheetExecute {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) throws Exception {
		Marksheet m = new Marksheet();
		System.out.println("Enter the number of students : ");
		int size = sc.nextInt(); // no. of students
		float grade[] = new float[size];
try {
	

		for (int i = 0; i < size; i++) { // input grades per student
			System.out.println("Grade of std[" + i + "] : ");
			grade[i] = sc.nextInt();
		}

		while(true) {
		try {
			
			System.out.println("Enter your choice : ");
			System.out.println("1. Average of grades");
			System.out.println("2. Maximum Grade");
			System.out.println("3. Minimum");
			System.out.println("4. Percentage of std. passed");
			System.out.println("5. Exit program");
			int option = sc.nextInt();
			switch (option) {
			case 1: { //find average of all grades
				System.out.printf("Average of Grades : %.2f\n",
						m.average(grade, grade.length));
				break;
			}
			case 2: { //find the maximum grade
				System.out.printf("Maximum Grade : %.2f\n", m.maxGrade(grade));
				break;
			}
			case 3: { //find the minimum grade
				System.out.printf("Minimum Grade : %.2f\n", m.minGrade(grade));
				break;
			}
			case 4: { //find the students who passed the exam 
				System.out.printf("Percentage of std. passed : %.2f\n",
						m.percentStudentPass(grade, grade.length));
				break;
			}
			case 5: { //Quit program
				System.out
						.println("Are you sure you want to exit program :(y/n)");
				sc.nextLine();
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
			default: { // Invalid choice
				System.out.println("Wrong Choice made...\n");
				break;
			}
			}
		} catch (Exception e) { // Invalid input 
			System.out.println("Invalid number...\n");
		}
	}
	}
catch(Exception e) // Invalid input , Like No. of studenst = 0
{
	System.out.println("Wrong input...\n");	
}
}
}
