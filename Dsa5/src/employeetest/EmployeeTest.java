package employeetest;

import static org.junit.Assert.*;

import org.junit.Test;

import employee.Employees;;
/**
 * @author kunal
 * Class containing testing methods
 */
public class EmployeeTest {
	@Test
	public void testRotation1() {
		Employees E = new Employees();
		E.insertIntoEmployee("Vartika", 20000, 30);
		E.insertIntoEmployee("Surendra", 20000, 30);
		E.insertIntoEmployee("Vinod", 30000, 40);
		E.insertIntoEmployee("Rahul", 30000, 25);
		E.insertIntoEmployee("Manoj", 10000, 22);
		E.insertIntoEmployee("Ajay", 30000, 20);
		E.insertIntoEmployee("Bhupendra", 30000, 10);
		E.insertIntoEmployee("Vinay", 30000, 5);
		E.insertionSort(E.headEmloye);
		E.printList();
		String[] result = E.printList();
		String[] expectedData = { "Vinay", "Bhupendra", "Ajay", "Rahul", "Vinod", "Vartika","Surendra",  "Manoj"};
		assertArrayEquals(expectedData, result);
	}
	@Test
	public void testRotation2() {
		Employees E = new Employees();
		E.insertIntoEmployee("Vartika", 20, 30);
		E.insertIntoEmployee("Surendra", 20, 30);
		E.insertIntoEmployee("Vinod", 30, 40);
		E.insertIntoEmployee("Rahul", 80, 25);
		E.insertIntoEmployee("Manoj", 70, 22);
		E.insertIntoEmployee("Ajay", 110, 20);
		E.insertIntoEmployee("Bhupendra", 250, 10);
		E.insertIntoEmployee("Vinay", 300, 5);
		E.insertionSort(E.headEmloye);
		E.printList();
		String[] result = E.printList();
		String[] expectedData = { "Vinay", "Bhupendra", "Ajay", "Rahul", "Manoj", "Vinod","Vartika",  "Surendra"};
		assertArrayEquals(expectedData, result);
	}
	@Test
	public void testRotation3() {
		Employees E = new Employees();
		E.insertIntoEmployee("Vartika", 100, 30);
		E.insertIntoEmployee("Surendra", 90, 30);
		E.insertIntoEmployee("Vinod", 80, 40);
		E.insertIntoEmployee("Rahul", 80, 25);
		E.insertIntoEmployee("Manoj", 70, 22);
		E.insertIntoEmployee("Ajay", 70, 20);
		E.insertIntoEmployee("Bhupendra", 60, 10);
		E.insertIntoEmployee("Vinay", 3, 5);
		E.insertionSort(E.headEmloye);
		E.printList();
		String[] result = E.printList();
		String[] expectedData = { "Vartika", "Surendra", "Rahul", "Vinod", "Ajay", "Manoj","Bhupendra",  "Vinay"};
		assertArrayEquals(expectedData, result);
	}
	@Test(expected = AssertionError.class) 
	public void testRotation4() {
		Employees E = new Employees();
		E.printList();
		String[] result = E.printList();
		String[] expectedData = {};
		assertArrayEquals(expectedData, result);
	}
}