package Stack.Zavorka;
import java.util.Stack;

public class Main {
    static String input = "(({{)}}))";

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        // jednoduché závorky
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    System.out.println("NEplatné závorky!");
                    break;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    System.out.println("NEplatné závorky!");
                    break;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    System.out.println("NEplatné závorky!");
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("NEplatné závorky!");
        } else {
            System.out.println("Jsou správně");
        }
        // System.out.println(stack);
    }

}
