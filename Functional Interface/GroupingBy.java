import java.util.*;
import java.util.stream.Collectors;
class Employee {
    String dept;
    int salary;
    Employee(String dept, int salary) {
        this.dept = dept;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return dept + ":" + salary;
    }
}
public class GroupingBy {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("IT", 5000),
            new Employee("HR", 3000),
            new Employee("IT", 7000),
            new Employee("HR", 3500),
            new Employee("Finance", 6000)
        );
        Map<String, Integer> totalSalaryByDept = employees.stream().collect(Collectors.groupingBy(e -> e.dept, Collectors.summingInt(e -> e.salary)));
        System.out.println("Total salary by department: " + totalSalaryByDept);
        Map<String, Long> countByDept = employees.stream().collect(Collectors.groupingBy(e -> e.dept, Collectors.counting()));
        System.out.println("Employee count by department: " + countByDept);
    }
}