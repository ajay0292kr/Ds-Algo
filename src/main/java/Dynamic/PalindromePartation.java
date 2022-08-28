package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromePartation {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);

            for (int i=0; i<allPart.size(); i++)
            {
                for (int j=0; j<allPart.get(i).size(); j++)
                {
                    System.out.print(allPart.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    private static boolean isPalindrome(String S, int start, int i)
    {
        while (start < i)
        {
            if (S.charAt(start++) != S.charAt(i--))
                return false;
        }
        return true;
    }
    private static void allPalPartitonsUtil(ArrayList<ArrayList<String>> allPart,
                                            Deque<String> currPart, int start, int n, String S) {
        if (start >= n)
        {
            allPart.add(new ArrayList<>(currPart));
            return;
        }
        for (int i = start; i < n; i++)
        {

            // If substring str[start..i] is palindrome
            if (isPalindrome(S, start, i))
            {
                currPart.addLast(S.substring(start, i + 1));

                // Recur for remaining remaining substring
                allPalPartitonsUtil(allPart, currPart, i + 1, n, S);

                // Remove substring str[start..i] from current
                // partition
                currPart.removeLast();
            }
        }
    }
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        ArrayList<ArrayList<String>> allPart = new ArrayList<>();
        int n = S.length();
        Deque<String> currPart = new LinkedList<String>();
        allPalPartitonsUtil(allPart, currPart, 0, n, S);
        return allPart;
    }
};

