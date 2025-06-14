package String.substring;

public class ReverseSubString {
    public static void printPattern(char s[], int n) {
        System.out.println(s);
        // reverse the String
        int i = 0, j = n-1;
        while (i < j) {
           char ch = s[i];
           s[i] = s[j];
           s[j] = ch;
           i++;
           j--;
        }
        i = 0;
        j = n-1;
        while (j -i > 0) {
            s[i] = s[j] = '*';
            System.out.println(s);
            i++;
            j--;
        }

    }
    public static void main(String[] args) {
        /*
            Input: str = “geeks”
            Output:
            geeks
            *kee*
            **e**
         */
        char[] s = "geeks".toCharArray();
        int n = s.length;

        printPattern(s, n);
    }
}
