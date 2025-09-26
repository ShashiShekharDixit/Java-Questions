import java.util.ArrayList;
import java.util.List;

class PersonCloneable implements Cloneable {
    String name;
    List<String> hobbies;

    PersonCloneable(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = hobbies;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class PersonCopy {
    String name;
    List<String> hobbies;

    PersonCopy(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = hobbies;
    }

    PersonCopy(PersonCopy other) {
        this.name = other.name;
        this.hobbies = new ArrayList<>(other.hobbies);
    }
}

public class CloneablePitfallsDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("-> Cloneable Pitfall <-");
        List<String> hobbies1 = new ArrayList<>();
        hobbies1.add("Reading");

        PersonCloneable p1 = new PersonCloneable("Shashi", hobbies1);
        PersonCloneable p2 = (PersonCloneable) p1.clone();
        p2.hobbies.add("Gaming"); 

        System.out.println("Original hobbies (p1): " + p1.hobbies);
        System.out.println("Cloned hobbies (p2):   " + p2.hobbies);

        System.out.println("\n-> Copy Constructor <-");
        List<String> hobbies2 = new ArrayList<>();
        hobbies2.add("Reading");

        PersonCopy c1 = new PersonCopy("Saurabh", hobbies2);
        PersonCopy c2 = new PersonCopy(c1); 
        c2.hobbies.add("Gaming"); 

        System.out.println("Original hobbies (c1): " + c1.hobbies);
        System.out.println("Copied hobbies (c2):   " + c2.hobbies);
    }
}