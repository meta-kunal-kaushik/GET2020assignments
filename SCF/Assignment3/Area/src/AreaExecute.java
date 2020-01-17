import java.util.Scanner;
/**
 * 
 * @author Kunal
 * @desc   This class uses predefined functions of class Area to calculate area of different shapes
 */
public class AreaExecute {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) throws ArithmeticException {
		Area area = new Area();

		try {
			System.out.println("Enter your choice : ");
			System.out.println("1. area of triangle");
			System.out.println("2. area of rectangle");
			System.out.println("3. area of circle");
			System.out.println("4. area of square");
			System.out.println("5. Quit program");
			int option = sc.nextInt(); // this variable is to ask user for what action should be performed from the above list 
			try {
				switch (option) {
				case 1: { // find area of triangle
					System.out.println("Enter base length : ");
					double base = sc.nextDouble();
					System.out.println("Enter height : ");
					double height = sc.nextDouble();
					System.out.println("Area of triangle = "
							+ area.triangleArea(base, height));
					break;
				}
				case 2: { // find area of reactangle
					System.out.println("Enter width : ");
					double width = sc.nextDouble();
					System.out.println("Enter height : ");
					double height = sc.nextDouble();
					System.out.println("Area of rectangle = "
							+ area.rectangleArea(width, height));
					break;
				}
				case 3: { // find area of circle
					System.out.println("Enter radius : ");
					double radius = sc.nextDouble();
					System.out.println("Area of circle = "
							+ area.circleArea(radius));
					break;
				}
				case 4: { //find area of square
					System.out.println("Enter width : ");
					double width = sc.nextDouble();
					System.out.println("Area of square = "
							+ area.squareArea(width));
					break;
				}
				case 5: { // Quit program
					System.out.println("Exit Successful");
					System.exit(0);
					break;
				}
				default: { // invalid choice
					System.out.println("Wrong choice made..\n");
					break;
				}
				}
			} catch (Exception e) {
				System.out.println("Exception : " + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("Wrong input..\n try again later");
		}

	}
}
