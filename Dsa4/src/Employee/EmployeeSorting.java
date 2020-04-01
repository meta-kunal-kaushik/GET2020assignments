package Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class EmployeeSorting {
	Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
	List<Integer> empIdList = new ArrayList<Integer>();
	private int count;
	public void addToEmployees(Employee emp){
		if(!employees.containsKey(emp.getEmpId())){
		employees.put(emp.getEmpId(), emp);
		empIdList.add(emp.getEmpId());
		}
	}
	public String [] sortByName(){
		count = employees.size();
		String str[] = new String[count];
		String temp;
		int indexStr=0;
		for ( Map.Entry<Integer, Employee> entry : employees.entrySet()) {
		    int key = entry.getKey();
		    String name = entry.getValue().getName();
		    str[indexStr++]=name;
		}
		
		for (int index = 0; index < count; index++) 
        {
            for (int j = index + 1; j < count; j++) { 
                if (str[index].compareTo(str[j])>0) 
                {
                    temp = str[index];
                    str[index] = str[j];
                    str[j] = temp;
                }
            }
        }
	return str;
	}
	
	public static void main(String[] args) {
		EmployeeSorting obj = new EmployeeSorting();
		obj.addToEmployees(new Employee("kunal",1,"abc nagar"));
		obj.addToEmployees(new Employee("keyur",12,"abc nagar"));
		obj.addToEmployees(new Employee("harshit",13,"abc nagar"));
		obj.addToEmployees(new Employee("rahul",3,"abc nagar"));
		obj.addToEmployees(new Employee("abhinav",5,"abc nagar"));
		obj.addToEmployees(new Employee("abhinav",5,"abc nagar"));
		String str[] = obj.sortByName();
		for(int index=0;index<str.length;index++){
			System.out.println(str[index]);
		}
	}
}
