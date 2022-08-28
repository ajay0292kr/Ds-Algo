package Amazon;

// Find the element that appears once
public class ElementAppearsOnce {
    public static int elementOccersOnce(int[] arr) {
        int ones = 0, twos = 0;
        int common_bit_mask;
        for (int i = 0; i < arr.length; i++) {
            /*"one & arr[i]" gives the bits that are there in
            both 'ones' and new element from arr[]. We
            add these bits to 'twos' using bitwise OR*/
            twos = twos | (ones & arr[i]);

            /*"one & arr[i]" gives the bits that are
            there in both 'ones' and new element from arr[].
            We add these bits to 'twos' using bitwise OR*/
            ones = ones ^ arr[i];

            /* The common bits are those bits which appear third time
            So these bits should not be there in both 'ones' and 'twos'.
            common_bit_mask contains all these bits as 0, so that the bits can
            be removed from 'ones' and 'twos'*/
            common_bit_mask = ~(ones & twos);

            /*Remove common bits (the bits that appear third time) from 'ones'*/
            ones &= common_bit_mask;

            /*Remove common bits (the bits that appear third time) from 'twos'*/
            twos &= common_bit_mask;
        }
        return ones;
    }
    public static void main(String[] args) {
        int[] arr = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3};
        System.out.println(elementOccersOnce(arr));
    }
}
