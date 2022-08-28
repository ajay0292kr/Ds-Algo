package String;

public class FreqOfTwoArray {
    // Frequency of a string in an array of strings
    //arr[] = {wer, wer, tyu, oio, tyu}
    //q[] =   {wer, tyu, uio}
    static int search(String str[], String q) {
        int cnt = 0;
        for (int i = 0; i<str.length; i++) {
            if(q.equals(str[i])) {
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {

        String[] arr = {"aba","baba","aba","xzxb"};
        String[] q   = {"aba","xzxb","ab"};
        for (int i=0;i<q.length; i++)
            System.out.print(search(arr, q[i]) + " ");
    }
}
