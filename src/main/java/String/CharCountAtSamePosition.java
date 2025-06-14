package String;

// Count characters at same position as in English alphabet
public class CharCountAtSamePosition {
    static int samePositionString(String str, int n) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == (str.charAt(i) - 'a')
                    || i == (str.charAt(i) - 'A'))
            {
                count++;
                System.out.print(str.charAt(i)+ " ");
            }
        }
       return count;
    }
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(samePositionString(str, str.length()-1));
    }
}
