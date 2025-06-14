package String.substring;

public class CountPalindromeSubString {
    final static int MAX_CHAR = 26;
    // function to return count of palindromic sub-string
    static int countPalindrome(String str) {
        int sum = 0;
        int n = str.length();

        // calculate frequency
        int hashTable[] = new int[MAX_CHAR];
        for (int i = 0; i < n; i++) {
           hashTable[str.charAt(i) - 'a']++;
        }
        // calculate count of palindromic sub-string
        for (int i = 0; i < 26; i++) {
            if (hashTable[i] != 0) {
                sum += (hashTable[i]* (hashTable[i]+1)/2);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        String str = "ananananddd";
        System.out.println(countPalindrome(str));
    }
}
