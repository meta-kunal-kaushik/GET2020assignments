package employee;

/**
 * @author kunal
 * class Employees is used to sort the employee salary on the basis of age and salary
 * high salary person will come first and low salary come next and if 
 * both have same salary then check age
 * 
 */
class EmpNode {
	String name;
	int age;
	int salary;
	EmpNode nextEmployee;

	/**
	 *Constructor is used to initialize the value of employee   
	 * @param name string type value
	 * @param age int type value
	 * @param salary int type value
	 */
	EmpNode(String name, int age, int salary) {
		this.age = age;
		this.salary = salary;
		this.name = name;
		this.nextEmployee = null;
	}
}

/**
 * the class Employees is used to implement the insertion sorting operaion
 * insertion sorting will sort the employees on the basis of salary and age
 */
public class Employees {
	public EmpNode headEmloye = null;
	EmpNode sorted;

	/**
	 * function is used to insert the employee details
	 * employee details are of int type age int type salary string type age
	 * @param name String type value
	 * @param salary int type salary
	 * @param age int type age
	 */
	public void insertIntoEmployee(String name, int salary, int age) {
		EmpNode newNode = new EmpNode(name, age, salary);
		if (headEmloye == null) {
			headEmloye = newNode;
		} else {
			EmpNode Temp = headEmloye;
			while (Temp.nextEmployee != null) {
				Temp = Temp.nextEmployee;
			}
			Temp.nextEmployee = newNode;
		}
	}

	/**
	 * function is used to print the data of employees
	 * @return 
	 */
	public String[] printList() {
		if(this.headEmloye == null){
			throw new AssertionError();
		}
		EmpNode temp = this.headEmloye;
		String[] nameofemp = new String[8];
		int i =0;
		while (temp != null) {
			nameofemp[i] = temp.name;
			i = i + 1;
			temp = temp.nextEmployee;
		}
		return nameofemp;
	}

	/**
	 * this function is used to call the sorting function
	 * which hold refrence of head node and next of head node
	 * @param headref
	 */
	public void insertionSort(EmpNode headref) {
		sorted = null;
		EmpNode current = headref;
		while (current != null) {
			EmpNode next = current.nextEmployee;
			sortedInsert(current);
			current = next;
		}
		this.headEmloye = sorted;
	}

	/**
	 * function to insert a new_node in a list. Note that this function expects
	 * a pointer to head_ref as this can modify the head of the input linked
	 * list (similar to push())
	 */
	void sortedInsert(EmpNode newnode) {

		if (sorted == null || sorted.salary < newnode.salary) {
			newnode.nextEmployee = sorted;
			sorted = newnode;
		} else if (sorted.salary == newnode.salary && sorted.age > newnode.age) {
			newnode.nextEmployee = sorted;
			sorted = newnode;
		} else {
			EmpNode current = sorted;
			while (current.nextEmployee != null
					&& current.nextEmployee.salary > newnode.salary) {
				current = current.nextEmployee;
			}
			newnode.nextEmployee = current.nextEmployee;
			current.nextEmployee = newnode;
		}
	}

}