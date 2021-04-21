package my.play.ground;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class HashXxxApp {
    public static void main(String[] args) {
        HashMap<String, Integer> map;
        HashSet<String> set;

        Hashtable<String, Integer> table = new Hashtable<>();
        table.put("1", 1);
        table.get("1");

        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1", 1);
    }
}
