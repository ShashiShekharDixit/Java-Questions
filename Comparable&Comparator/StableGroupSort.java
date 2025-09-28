import java.util.*;
class Person {
    String name;
    int age;   
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
}
public class StableGroupSort {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Shashi", 25),
            new Person("Shekhar", 30),
            new Person("Saurabh", 25),
            new Person("Priya", 20),
            new Person("Sachin", 30)
        );
        Map<Integer, List<Person>> buckets = new TreeMap<>(); 
        for (Person p : people) {
            buckets.computeIfAbsent(p.age, k -> new ArrayList<>()).add(p);
        }
        List<Person> grouped = new ArrayList<>();
        for (List<Person> group : buckets.values()) {
            grouped.addAll(group); 
        }
        System.out.println("Grouped (stable): " + grouped);
    }
}
