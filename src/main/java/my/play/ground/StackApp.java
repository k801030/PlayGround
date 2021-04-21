package my.play.ground;

import java.util.Stack;

public class StackApp {
    public void operation() {
        Stack<String> stack = new Stack<>();
        stack.add("A");
        stack.pop();
        stack.peek();
        stack.isEmpty();
    }
}
