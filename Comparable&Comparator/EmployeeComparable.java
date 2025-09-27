import java.util.*;
class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private double salary;
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    @Override
    public int compareTo(Employee other) {
        int salaryCmp = Double.compare(this.salary, other.salary);
        if (salaryCmp != 0) return salaryCmp;  
        return Integer.compare(this.id, other.id); 
    }
    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', salary=%.2f}", id, name, salary);
    }
}
public class EmployeeComparable {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(3, "Shashi", 50000));
        employees.add(new Employee(1, "Saurabh", 70000));
        employees.add(new Employee(2, "Shekhar", 50000));
        employees.add(new Employee(4, "Sachin", 60000));
        Collections.sort(employees);
        System.out.println("Employees sorted by salary then id:");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
