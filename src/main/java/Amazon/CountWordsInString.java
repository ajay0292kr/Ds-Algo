package Amazon;

import java.util.HashMap;
import java.util.Map;

public class CountWordsInString {
    // Count words that appear exactly two times in an array of words
    static int twoTimesWordCount(String str[]) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : str) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<String,Integer> result: map.entrySet()) {
            if (result.getValue() == 2) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
    String[] str = {"Om", "Om", "Shankar", "Tripathi",
            "Tom", "Jerry", "Jerry"};
    System.out.println("Two times appears word count = "+ twoTimesWordCount(str));
    }
}
