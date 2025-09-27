import java.util.*;
public class VersionSort {
    public static void main(String[] args) {
        List<String> versions = Arrays.asList("1.10", "1.2", "2.0", "1.2.0", "1.2.1", "1.11");
        versions.sort(new VersionComparator());
        System.out.println("Sorted versions: " + versions);
    }
}
class VersionComparator implements Comparator<String> {
    @Override
    public int compare(String v1, String v2) {
        String[] parts1 = v1.split("\\.");
        String[] parts2 = v2.split("\\.");
        int length = Math.max(parts1.length, parts2.length);
        for (int i = 0; i < length; i++) {
            int num1 = (i < parts1.length) ? Integer.parseInt(parts1[i]) : 0;
            int num2 = (i < parts2.length) ? Integer.parseInt(parts2[i]) : 0;
            if (num1 != num2) {
                return Integer.compare(num1, num2);
            }
        }
        return 0; 
    }
}