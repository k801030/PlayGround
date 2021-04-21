package my.play.ground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListApp {

    public static void main(String[] args) {
        ListApp app = new ListApp();
        app.immutableList();
    }

    public void immutableList() {
        List<String> a = Arrays.asList("a");
        a.add(".");
        List<String> b = Arrays.asList("a");
        b.add(".");

    }

    public void addFirst() {
        ArrayList<String> a = new ArrayList<>();
        a.add(0, "123");
    }

    public void arrayList() {
        ArrayList<Integer>[] arrayLists = new ArrayList[1];

    }
}
