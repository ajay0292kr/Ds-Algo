package SlidingWindows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringWordCount {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> answer = new ArrayList<>();

        int wordCount = words.length;
        int wordLen = words[0].length();
        int stringLen = s.length();
        int expectedSubstrLen = wordCount * wordLen;

        // Populate the dictionary to see how many word copies
        // we should expect (there may be duplicates).
        Map<String, Integer> dict = new HashMap<>();
        for (String word : words) {
            dict.put(word, dict.getOrDefault(word, 0) + 1);
        }
        // Though all words have the same length, substrings consisting
        // of those words need not be aligned with the input string.
        // Hence, account for all starting positions up to the length
        // of a word.

        for (int i = 0; i < wordLen; i++) {
            int substringStart = i;
            Map<String, List<Integer>> wordIndices = new HashMap<>();
            // Iterate by word length until the end of the string.
            for (int j = i; j <= stringLen - wordLen; j += wordLen) {
                // Get the word and find out how many word copies we are expecting.
                String word = s.substring(j, j + wordLen);
                int wordCopies = dict.getOrDefault(word, 0);

                // If none, consider the chain broken and reset.
                if (wordCopies == 0) {
                    wordIndices.clear();
                    substringStart = j + wordLen;
                }
                else {
                    // Get all the positions at which we have seen this word.
                    List<Integer> prevWordIndices =
                            wordIndices.computeIfAbsent(word, k -> new ArrayList<>());

                    // Keep removing old positions if that puts us over
                    // the word copies quota. Additionally, reset the chain
                    // start whenever one of those quota-exceeding positions
                    // is considered for the chain under construction.
                    while (!prevWordIndices.isEmpty()) {
                        int prevWordIndex = prevWordIndices.get(0);
                        if (prevWordIndices.size() >= wordCopies) {
                            if (prevWordIndex >= substringStart) {
                                substringStart = prevWordIndex + wordLen;
                            }
                            prevWordIndices.remove(0);
                        } else {
                            break;
                        }
                    }

                    // If, together with the current word, we get a chain
                    // of the expected length, then we have found an answer.
                    if (j - substringStart + wordLen == expectedSubstrLen) {
                        answer.add(substringStart);
                    }

                    // Update the current word's positions.
                    prevWordIndices.add(j);
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
