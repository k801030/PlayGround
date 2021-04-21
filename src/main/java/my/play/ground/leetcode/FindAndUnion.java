package my.play.ground.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class FindAndUnion {

    public static void main(String[] args) {
        int[] list = new int[]{0, 0, 1, 2, 3, 4, 6};
        FindAndUnion app = new FindAndUnion();
        app.union(list, 5, 6);

        log.info("{}", Arrays.toString(list));
    }

    private int find(int[] list, int a) {
        if (list[a] == a) return a;
        list[a] = find(list, list[a]);
        return list[a];
    }

    private void union(int[] list, int a, int b) {
        a = find(list, a);
        b = find(list, b);
        list[a] = b;
    }
}
