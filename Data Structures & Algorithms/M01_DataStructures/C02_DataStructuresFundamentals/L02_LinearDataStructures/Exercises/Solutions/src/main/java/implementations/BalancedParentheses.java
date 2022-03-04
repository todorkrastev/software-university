package implementations;

import interfaces.Solvable;

import java.util.Deque;
import java.util.LinkedList;

public class BalancedParentheses implements Solvable {
    private final String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : this.parentheses.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                deque.addFirst(ch);
            } else {
                if (!deque.isEmpty()
                        && ((deque.peekFirst() == '{' && ch == '}')
                        || (deque.peekFirst() == '[' && ch == ']')
                        || (deque.peekFirst() == '(' && ch == ')'))) {
                    deque.removeFirst();
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
