package Array;

public class RearrangeBinaryString {
    static void arrangeString(String str, int x, int y) {
        int count_0 = 0, count_1 = 0;
        for(int i = 0; i<str.length(); i++) {
            if(str.charAt(i) == '0') {
                count_0++;
            }else {
                count_1++;
            }
        }
        while(count_0 > 0 || count_1 > 0) {
            for(int j = 0; j <x && count_0 > 0; j++) {
                System.out.print("0" + " ");
                count_0-- ;
            }
            for(int j = 0; j<y && count_1 > 0; j++) {
                System.out.print("1" + " ");
                count_1--;
            }
        }
    }
    public static void main(String[] args) {
        String str = "01101101101101101000000";
        int x = 1;
        int y = 2;
        arrangeString(str, x, y);
    }
}
