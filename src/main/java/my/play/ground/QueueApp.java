package my.play.ground;

import java.util.LinkedList;
import java.util.Queue;

public class QueueApp {
    public void operation() {
        Queue<String> queue = new LinkedList<>();
        queue.add("A");
        queue.poll();
        queue.remove();
        queue.peek();
        queue.isEmpty();
    }

    public void addByIndex(int index, LinkedList<String> list) {
        list.add(index, "1");
    }

    public static void main(String[] args) {
        QueueApp app = new QueueApp();
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0 ; i < 10; i++) {
            list.add("1");
        }
        app.addByIndex(0, list);
        app.addByIndex(1, list);
        app.addByIndex(9, list);
    }
}
