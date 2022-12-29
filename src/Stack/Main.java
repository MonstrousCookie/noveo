package Stack;

import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        String[] testCases = { "()", "{}", "[]", "({[]})", "(]", "([)]" };

        for (String testCase : testCases) {
            System.out.println(isValid(testCase));
        }

    }
    // O(N) Time
    // O(M) Space where M is the number of input brackets
    public static boolean isValid(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> brackets = Map.of('(', ')', '{', '}', '[',']');
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (brackets.containsKey(aChar)) {
                stack.push(aChar);
            }
            if (aChar == brackets.get(stack.peek())) {
                stack.pop();
            }
        }
        return stack.size() == 0;
    }

}
