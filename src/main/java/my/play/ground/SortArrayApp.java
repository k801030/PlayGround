package my.play.ground;

import lombok.extern.log4j.Log4j;

import java.util.Arrays;
import java.util.List;

@Log4j
public class SortArrayApp {

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 3,}, {2, 4}, {6, 10}, {6, 9}, {1, 2}};
        log.info(Arrays.toString(array));
        sort(array);
        log.info(Arrays.toString(array));
    }

    static void sort(int[][] array) {
        Arrays.sort(array, (a, b) -> a[0] - b[0]);
    }

    static void list() {
        List<int[]> intArrayList;
        // List<int> intList;
    }
}
