package String;

// Find k’th character of decrypted string
public class KthCharacterInDecrypt {

    /* Input: "a2b2c3", k = 5
       Output: c

     */
 //temp= aabbccc
    static char encodedChar(String str, int k) {
        String temp = "";
        String expend = "";

        int freq = 0;

        for (int i = 0; i<str.length();) {

            temp = "";
            freq = 0;
            while (i < str.length() && str.charAt(i) >= 'a' && str.charAt(i) <='z') {
                temp+=str.charAt(i);
                i++;
            }
            while (i < str.length() && str.charAt(i) >='1' && str.charAt(i) <='9') {
                freq = freq*10 + str.charAt(i) - '0';
                i++;
            }

            for (int j = 1; j<=freq; j++) {
                expend+=temp;
            }
        }
        if(freq == 0) {
            expend+=temp;
        }
        return expend.charAt(k-1);
    }
    public static void main(String[] args) {
        String str = "ab4c12ed3";
        int k = 21;
        System.out.println(encodedChar(str, k));
    }
}
