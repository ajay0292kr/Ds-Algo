package Stack;

import java.util.Stack;

public class ValidParenthses {
    // Method to check if the expression has valid braces
    public static boolean isValid(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            // If opening brace, push it to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If closing brace, check for matching opening brace
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false; // No matching opening brace
                }
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false; // Mismatched pair
                }
            }
        }

        return stack.isEmpty(); // Stack should be empty if valid
    }
    // Method to match pairs of braces
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
    public static void main(String[] args) {
     String str = "({()})";
     System.out.print(str);
    }
}
