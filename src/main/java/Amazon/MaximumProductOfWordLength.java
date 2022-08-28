package Amazon;

public class MaximumProductOfWordLength {
    public static int maxProduct(String[] words) {
        int result = 0;
        int[] binArr = new int[words.length];
        for (int i=0; i<words.length; i++) {
            binArr[i] = convertToBinary(words[i]);
        }

        for (int i=0; i<words.length-1; i++) {
            for (int j=i+1; j<words.length; j++) {
                if ((binArr[i] & binArr[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }

        return result;
    }

    public static int convertToBinary(String word) {
        int result = 0;
        for (char c : word.toCharArray()) {
            int tmp = 1 << (c-'a');
            result = result | tmp;
        }
        return result;
    }
    public static void main(String[] args) {
        String[] str = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProduct(str));
    }
}
