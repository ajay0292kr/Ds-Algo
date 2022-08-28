package Amazon;

public class FormMaximumNumberUsingDigit {
    // Find maximum number that can be formed using digits of a given number
    //Input : 38293367
    // Output : 98763332
    static int printMaxNum(int num) {
        int[] count = new int [10];
        String str = Integer.toString(num);

        for (int i = 0; i<str.length(); i++) {
            count[str.charAt(i)-'0']++;
        }
        int result = 0, multiplier = 1;

        for (int i = 0; i<=9; i++) {
            while (count[i] > 0) {
                result = result + (i * multiplier);
                count[i]--;
                multiplier = multiplier*10;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int num = 38293367;
        System.out.println(printMaxNum(num));
    }
}
