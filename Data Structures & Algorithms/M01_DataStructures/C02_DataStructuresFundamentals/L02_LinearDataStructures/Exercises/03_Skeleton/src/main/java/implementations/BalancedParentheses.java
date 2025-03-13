package implementations;

import interfaces.Solvable;
import java.util.Stack;

public class BalancedParentheses implements Solvable {
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < parentheses.length(); i++) {
            char current = parentheses.charAt(i);
            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            } else if (current == ')' || current == '}' || current == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();
                if ((current == ')' && last != '(') ||
                        (current == '}' && last != '{') ||
                        (current == ']' && last != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}