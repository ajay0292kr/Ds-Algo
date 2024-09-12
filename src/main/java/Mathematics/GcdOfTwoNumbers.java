package Mathematics;

public class GcdOfTwoNumbers {
    // Lcm & gcd of two numbers
    static int gcd(int a, int b) {
        if(a== 0) return b;
        return gcd(b%a, a);
    }
    // LCM of two numbers
    static int lcm(int a, int b) {
        return (a*b)/gcd(a,b);
    }
    // LCM of array
   static int lcmArray(int[] arr) {
        int res = arr[0];
       for (int j : arr) {
           res = (res * j) / gcd(j, res);
       }
        return res;
   }
   // GCD of an array
    static int gcdArray(int []str) {
        int res = str[0];
        for(int j : str) {
            res = gcd(j, res);
            if(res == 1)
            {
                return 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int a = 2, b = 3;
        int [] arr = {1, 2, 8, 3};
        int [] str = {2, 4, 6, 8};

        System.out.println("GCD = "+gcd(a,b));
        System.out.println("LCM = "+lcm(a,b));
        System.out.println("LCM of array = "+lcmArray(arr));
        System.out.println("GCD of an array = "+gcdArray(str));
    }
}

// Time Complexity: O(log(max(a,b))
// Auxiliary Space: O(log(max(a,b))

// add another method