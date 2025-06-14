package General;

public class CharacterConversion {
    public static String convertString(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isUpperCase(ch)) {
                ch = (char)(ch+1);

                if (ch > 'Z') {
                    ch = 'A';
                }
            }
            if (Character.isLowerCase(ch)) {
                ch = (char)(ch-1);

                if (ch < 'a') {
                    ch = 'z';
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String input = "APZzYGRb";
        String output = convertString(input);
        System.out.println("Output: " + output);
    }
}
