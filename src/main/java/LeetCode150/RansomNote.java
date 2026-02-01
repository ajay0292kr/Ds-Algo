package LeetCode150;

public class RansomNote {
    /*
      Given two strings ransomNote and magazine, return true if ransomNote can be constructed
      by using the letters from magazine and false otherwise.
      Each letter in magazine can only be used once in ransomNote.
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        int m[] = new int [26];
        for(char c: magazine.toCharArray()) {
            m[c-'a'] +=1;
        }
        for(char c: ransomNote.toCharArray()) {
            if(m[c-'a']==0) {
                return false;
            }
            m[c-'a'] -=1;
        }
        return true;
    }
    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        System.out.print(canConstruct(ransomNote, magazine));
    }
}
