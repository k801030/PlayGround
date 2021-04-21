package my.play.ground;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StreamApp {

    public static void main(String[] args) {
        StreamApp app = new StreamApp();
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        app.parallelStream(list);
    }

    private void join(List<Integer> list) {
        String s = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    private void parallelStream(List<Integer> list) {
        list.parallelStream().forEach(i -> log.info("{}", i));
    }
}
