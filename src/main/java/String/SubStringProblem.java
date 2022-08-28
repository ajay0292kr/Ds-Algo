package String;

public class SubStringProblem {
    // Check if a string can become empty by recursively deleting a given sub-string
    static boolean canBecomeEmpty(String str, String sub_str) {
        while (str.length() > 0) {
            int idx = str.indexOf(sub_str);
            if (idx == -1) break;
            str = str.replaceFirst(sub_str, "");
        }
        return (str.length() == 0);
    }
    public static void main(String[] args) {
        String str = "GEEGEEKSKS", sub_str = "GEEKS";
        if (canBecomeEmpty(str, sub_str)) {
            System.out.print("\nYes");
        } else {
            System.out.print("\nNo");
        }
    }
}
