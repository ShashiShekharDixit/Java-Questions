import java.util.*;
class Student {
    String name;
    double cgpa;
    int age;
    Student(String name, double cgpa, int age) {
        this.name = name;
        this.cgpa = cgpa;
        this.age = age;
    }
    @Override
    public String toString() {
        return String.format("Student{name='%s', cgpa=%.2f, age=%d}", name, cgpa, age);
    }
}
public class StudentSort {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Shashi", 9.1, 20),
            new Student("Shekhar", 9.5, 22),
            new Student("Saurabh", 9.1, 19),
            new Student("Sachin", 8.9, 21)
        );
        students.sort(
            Comparator.comparingDouble((Student s) -> s.cgpa).reversed().thenComparing(s -> s.name).thenComparingInt(s -> s.age)                      
        );
        System.out.println("Sorted students:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
