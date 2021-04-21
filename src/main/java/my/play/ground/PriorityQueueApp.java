package my.play.ground;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class PriorityQueueApp {
    public void init() {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a-b);
        pq.poll();
        pq.remove();
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue() != 0 ? a.getValue() - b.getValue() : -a.getKey().compareTo(b.getKey()));
    }
}
