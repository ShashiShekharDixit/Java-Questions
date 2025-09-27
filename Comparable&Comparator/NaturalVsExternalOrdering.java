import java.util.*;
class Person implements Comparable<Person> {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
    @Override
    public String toString() {
        return String.format("Person{name='%s', age=%d}", name, age);
    }
}
public class NaturalVsExternalOrdering {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Shashi", 25),
            new Person("Shekhar", 30),
            new Person("Saurabh", 22),
            new Person("Sachin", 28)
        );
        List<Person> byName = new ArrayList<>(people);
        Collections.sort(byName);
        System.out.println("Sorted by natural ordering (name): " + byName);
        List<Person> byAge = new ArrayList<>(people);
        byAge.sort(Comparator.comparingInt(p -> p.age));
        System.out.println("Sorted by external ordering (age): " + byAge);
        List<Person> byAgeDesc = new ArrayList<>(people);
        byAgeDesc.sort(Comparator.comparingInt((Person p) -> p.age).reversed());
        System.out.println("Sorted by external ordering (age descending): " + byAgeDesc);
    }
}
