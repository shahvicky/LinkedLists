import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorComparable {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(5, "Vivek"));
		employees.add(new Employee(2, "Manish"));
		employees.add(new Employee(10, "Prabhat"));
		employees.add(new Employee(3, "Mehak"));
		System.out.println(employees);
		Collections.sort(employees);
		System.out.println(employees);
		
		
		Comparator<Employee> sortEmp = new Comparator<Employee>() {
			
			public int compare(Employee e1, Employee e2) {
				return e1.name.compareTo(e2.name);
			}
		};
		
		Collections.sort(employees, sortEmp);
		System.out.println(employees);
	}

}

class Employee implements Comparable<Employee> {
	int id;
	String name;
	
	Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int compareTo(Employee e) {
		return this.id - e.id;
	}
	
	public String toString() {
		return this.id+" "+ this.name;
	}
	
}