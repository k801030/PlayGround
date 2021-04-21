package my.play.ground;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class LinkedHashMapApp {

    public static void main(String[] args) {
        LinkedHashMap<Integer, Campaign> map = new LinkedHashMap<>();

        map.put(3, new Campaign().setId(1).setTitle("title 1"));
        map.put(2, new Campaign().setId(5).setTitle("title 2"));
        map.put(5, new Campaign().setId(2).setTitle("title 3"));

        for (Map.Entry<Integer, Campaign> entry : map.entrySet()) {
            log.info("{}, {}", entry.getKey(), entry.getValue().getId());
        }

        Object[] array = map.values().toArray();
        for (Object c : array) {
            log.info("{}", ((Campaign)(c)).getId());
        }


        List<Integer> list2 = Arrays.asList(1,2,3,4,5).subList(0, 0);
        List<Integer> list = Arrays.asList(1,2,3,4,5).subList(0, 2);
        for (int i : list) {
            log.info("{}", i);
        }
        list.addAll(list2);
    }
}

@Setter
@Getter
@Accessors(chain = true)
class Campaign {
    int id;
    String title;
}