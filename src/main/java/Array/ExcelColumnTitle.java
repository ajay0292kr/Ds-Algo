package Array;

public class ExcelColumnTitle {
    static void printString(int number) {
        StringBuilder columnNumber = new StringBuilder();
        while (number > 0) {
            int rem = number%26;
            if(rem == 0) {
                columnNumber.append("Z");
                number = (number/26) - 1;
            }else {
                columnNumber.append((char)((rem-1)+'A'));
                number = number/26;
            }
        }
        System.out.println(columnNumber.reverse());
    }
    public static void main(String[] args) {
        printString(26);
        printString(51);
        printString(52);
        printString(80);
    }
}
