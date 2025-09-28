import java.util.*;
class Department {
    String name;
    Department(String name) { this.name = name; }
}
class Employee {
    String name;
    Department dept; 
    Employee(String name, Department dept) {
        this.name = name;
        this.dept = dept;
    }
    @Override
    public String toString() {
        return name + " (" + (dept == null ? "No Dept" : dept.name) + ")";
    }
}
public class NestedComparator {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Shashi", new Department("Finance")));
        employees.add(new Employee("Shekhar", null));
        employees.add(new Employee("Saurabh", new Department("HR")));
        employees.add(new Employee("Akshay", new Department("Finance")));
        employees.add(new Employee("Om", null));
        Comparator<Employee> comparator =
            Comparator.comparing(
                (Employee e) -> e.dept == null ? null : e.dept.name,
                Comparator.nullsFirst(String.CASE_INSENSITIVE_ORDER)
            ).thenComparing(e -> e.name);
        employees.sort(comparator);
        System.out.println("Employees sorted by department (nulls first), then name:");
        employees.forEach(System.out::println);
    }
}
