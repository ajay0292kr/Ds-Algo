package String;

public class CommonSubStringWithBinary {
    // Longest common substring in binary representation of two numbers
    static int longestCommon(int m, int n) {
        int mx = -Integer.MAX_VALUE; // maximum length
        String s1 = Integer.toBinaryString(n);
        String s2 = Integer.toBinaryString(m);
        String res = null;  // final resultant string
        int len = s1.length();
        int l = len;
        while (len > 0)
        {
            for (int i = 0; i < l - len + 1; i++)
            {
                String temp = s1.substring(i, i + len);

                int tlen = temp.length();
                if (tlen > mx && s2.contains(temp))
                {
                    res = temp;
                    mx = tlen;
                }
            }

            len = len - 1;
        }
        if(res == "")
            return -1;

        return Integer.parseInt(res,2);
    }
    public static void main(String[] args) {
        int n = 10;
        int m = 11;
        System.out.println("Longest common decimal value : "
                +longestCommon(m, n));
    }
}
