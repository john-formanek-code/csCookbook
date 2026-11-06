package Stack.Zavorka;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main2 {
    static String input = "(({{)}}))";
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');
    

    for (char c : input.toCharArray()) {
        if (pairs.containsValue(c)) { // otevírací
            stack.push(c);
        } else if (pairs.containsKey(c)) { // zavírací
            if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                System.out.println("NEplatné závorky!");
                break;
            }
        }
    }
    }
}
