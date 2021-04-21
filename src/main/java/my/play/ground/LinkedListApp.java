package my.play.ground;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedListApp {
    public List<Integer> fromFirst(LinkedList<Integer> list) {
        list.offer(1);
        list.offerFirst(1);
        list.add(0, 1);
        list.peek();
        list.remove();
        list.add(1);
        return list;
    }

    public List<Integer> fromFirst(List<Integer> list) {
        list.remove(1);
        return list;
    }


    public List<List<Integer>> toListOfList(List<LinkedList<Integer>> list) {
        // return list;
        List<List<Integer>> lists = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        lists.add(linkedList);
        return null;
    }

    public void add(ArrayList<Integer> list) {
        list.add(1, 1);
    }
}
