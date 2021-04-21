package my.play.ground;

import java.util.*;

public class SetApp {

    public void add(Set<Integer> set, int num) {
        set.add(num);
    }

    public List<Integer> emptyList() {
        return Collections.emptyList();
    }

    public List<Integer> arraysOf() {
        return Arrays.asList(1,2,3);
    }

    public void remove(Set<Integer> set, int num) {
        set.remove(Integer.valueOf(num));
        set.remove(1);
        for (int i : set) {

        }
    }

    private void setToList(Set<Integer> set) {
        List list = new ArrayList(set);
    }

    private void treeSet(TreeSet<Integer> set) {
        set.add(1);
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("1", "1");
    }
}
