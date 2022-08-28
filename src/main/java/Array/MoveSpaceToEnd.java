package Array;

public class MoveSpaceToEnd {
    static char[] moveSpaceInFront(char str[]) {
        int i = str.length - 1;
        for(int j = i; j>=0; j--) {
            if(str[j] != ' ') {
                char ch = str[i];
                str[i] = str[j];
                str[j] = ch;
                i--;
            }
        }
       return str;
    }
    public static void main(String[] args) {
        char str[] = "Hey there".toCharArray();
        moveSpaceInFront(str);
        System.out.println(String.valueOf(str));
    }
}
