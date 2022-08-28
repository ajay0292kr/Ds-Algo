package Amazon;
import java.util.*;
public class Equation {
    // Find the missing value from the given equation a + b = c
    static int findMissing(String str) {
        String[] arrStr = str.split(" ");
        int pos = -1;
        if (arrStr[0].equals("?")) {
            pos = 0;
        }else if (arrStr[2].equals("?")) {
            pos = 2;
        }else {
            pos = 4;
        }

        if (pos == 0) {
            String b,c;
            b = arrStr[2];
            c = arrStr[4];
            int a = Integer.parseInt(c) - Integer.parseInt(b);
            return a;
        }
        else if (pos == 2) {
            String a, c;
            a = arrStr[0];
            c = arrStr[4];
            int b = Integer.parseInt(c) - Integer.parseInt(a);
            return b;
        }else if (pos == 4) {
            String a,b;
            a = arrStr[0];
            b = arrStr[2];
            int c = Integer.parseInt(a) - Integer.parseInt(b);

            return c;
        }
        return 0;
    }
    public static void main(String[] args) {
      String str = "? + 3 = 7";
      System.out.print(findMissing(str));
    }
}
