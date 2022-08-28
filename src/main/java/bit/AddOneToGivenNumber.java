package bit;

public class AddOneToGivenNumber {
    // Write a program to add one to a given number.
    // The use of operators like ‘+’, ‘-‘, ‘*’, ‘/’, ‘++’, ‘–‘ …etc are not allowed.
    public static void add(int n) {
       // int result = 0;
        //result = n^1;
        System.out.println((-(~n)));
    }
    public static void main(String[] args) {
        int n = 8;
        add(n);
    }
}
