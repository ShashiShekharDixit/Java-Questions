public class VersionCompare {
    public static int compareVersion(String v1, String v2) {
        String[] arr1 = v1.split("\\.");
        String[] arr2 = v2.split("\\.");
        int n = Math.max(arr1.length, arr2.length);
        for (int i = 0; i < n; i++) {
            int num1 = i < arr1.length ? Integer.parseInt(arr1[i]) : 0;
            int num2 = i < arr2.length ? Integer.parseInt(arr2[i]) : 0;
            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
        }
        return 0; 
    }
    public static void main(String[] args) {
        String v1 = "1.10";
        String v2 = "1.2";
        int result = compareVersion(v1, v2);
        if (result < 0) System.out.println(v1 + " < " + v2);
        else if (result > 0) System.out.println(v1 + " > " + v2);
        else System.out.println(v1 + " = " + v2);
    }
}
