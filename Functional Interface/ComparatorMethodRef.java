import java.util.*;
class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
public class ComparatorMethodRef {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Shashi", 20),
            new Person("Shekhar", 24),
            new Person("Dixit", 30)
        );
        people.sort(Comparator.comparing(Person::getAge));
        System.out.println("Sorted by age: " + people);
        people.sort(Comparator.comparing(Person::getAge).reversed());
        System.out.println("Sorted by age descending: " + people);
    }
}
