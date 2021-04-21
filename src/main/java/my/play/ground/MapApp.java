package my.play.ground;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MapApp {
    public static void main(String[] args) {
        MapApp app = new MapApp();
        app.putIfAbsent(new HashMap<>());
    }

    private void entry(Map<String, Integer> map) {

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

        }

        for (String s : map.keySet()) {

        }

        for (int i : map.values()) {

        }
    }

    private void putIfAbsent(Map<String, String> map) {
        String s = map.putIfAbsent("a", "list");
        s = map.putIfAbsent("a", "list");
        log.info(s.toLowerCase());

    }

    private void containsKey(HashMap<Integer, Integer> map) {
        map.containsKey(1);
        map.get(1);
    }


}
