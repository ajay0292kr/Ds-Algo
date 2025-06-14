package Stack;

import java.util.Stack;

/*public class MakeValidP {
    // Method to make an expression valid by adding missing braces
    public static String makeValid(String expression) {
        StringBuilder fixedExpression = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                fixedExpression.append(ch);
            }else if (ch == ')' || ch == '}' || ch == ']') {
                if (!stack.isEmpty() && isMatchingPair(stack.peek(), ch)) {
                    stack.pop();
                    fixedExpression.append(ch);
                } else {
                    // Add corresponding opening brace if missing
                    fixedExpression.insert(0, getOpeningBrace(ch));
                    fixedExpression.append(ch);
                }
            }
            else {
                    fixedExpression.append(ch); // Append other characters as is
                }
            // Add remaining unmatched opening braces
            while (!stack.isEmpty()) {
                char open = stack.pop();
                fixedExpression.append(getClosingBrace(open));
            }
            return fixedExpression.toString();
    }
        // Helper methods to get corresponding braces
        private static char getOpeningBrace(char close) {
            switch (close) {
                case ')': return '(';
                case '}': return '{';
                case ']': return '[';
                default: throw new IllegalArgumentException("Invalid closing brace: " + close);
            }
        }
        private static char getClosingBrace(char open) {
            switch (open) {
                case '(': return ')';
                case '{': return '}';
                case '[': return ']';
                default: throw new IllegalArgumentException("Invalid opening brace: " + open);
            }
        }
    public static void main(String[] args) {
            String expression = "{[(a+b)*(c-d)]"; // Example with missing brace
            if (isValid(expression)) {
                System.out.println("The expression is valid.");
            } else {
                System.out.println("The expression is invalid. Making it valid...");
                String validExpression = makeValid(expression);
                System.out.println("Valid expression: " + validExpression);
            }
    }
}*/
