package Array;

public class SumOfMiddleElements {
    // Time Complexity : O(n)
    // Auxiliary Space: O(1)
    // Sum of Middle Elements of two sorted arrays
    public static int getMedian(int ar1[], int []ar2, int n1, int n2) {
        int i = 0,j = 0;
        int m1 = -1, m2 = -1;
        int count;
        for(count = 0; count <=n1; count++) {
            // Below is to handle case
            // where all elements of ar1[]
            // are smaller than smallest
            // (or first) element of ar2[]
            if(i == n1) {
                m1 = m2;
                m2 = ar2[0];
                break;
            }
            /* Below is to handle case where all
            elements of ar2[] are smaller than
            smallest(or first) element of ar1[] */
            if(j == n2) {
                m1 = m2;
                m2 = ar1[0];
                break;
            }
            if(ar1[i] <= ar2[j]) {
                m1 = m2;
                m2 = ar1[i++];
            }else {
                m1 = m2;
                m2 = ar2[j++];
            }
        }
        return (m1+m2)/2;
    }
    public static void main(String[] args) {
        int []ar1 = {1, 12, 15, 26, 38};
        int []ar2 = {2, 13, 17, 30, 45};
        int n1 = ar1.length;
        int n2 = ar2.length;
        if(n1 == n2) {
            System.out.print(getMedian(ar1, ar2, n1, n2));
        }
    }
}
