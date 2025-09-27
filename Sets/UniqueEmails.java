import java.util.*;
public class UniqueEmails {
    public static int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0].split("\\+")[0]; 
            local = local.replace(".", "");           
            String normalized = local + "@" + parts[1];
            unique.add(normalized);
        }
        return unique.size();
    }
    public static void main(String[] args) {
        String[] emails = {
            "test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com",
            "testemail+david@lee.tcode.com",
            "test.email@leetcode.com"
        };
        System.out.println("Number of unique emails: " + numUniqueEmails(emails));
    }
}
