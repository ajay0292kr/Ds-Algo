package bit;

public class PowerBit {
    // Find whether a given number is a power of 4 or not
    // First approach
    static int isPowerOfFour(int n)
    {
        if(n == 0)
            return 0;
        while(n != 1)
        {
            if(n % 4 != 0)
                return 0;
            n = n / 4;
        }
        return 1;
    }
    // Second approach
    public static int power(int n) {
        int x = n & n-1; /*Check if there is only one bit set in n*/
        int cnt = 0;
        if(n > 0 && x == 0) {
            /* count 0 bits
            before set bit */
            while(n>1) {
                n>>=1;
                cnt+=1;
            }
            /*If count is even
            then return true
            else false*/
            return (cnt%2 == 0)? 1:0;
        }
        return 0;
    }
    public static void main(String[] args) {
        int n = 16;
        int ans = power(n);
        if(ans>0)
            System.out.println("Number is power of 4 "+n);
        else
            System.out.println("Number is not power of 4 "+n);
    }
}
