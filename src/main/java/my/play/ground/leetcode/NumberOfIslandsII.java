package my.play.ground.leetcode;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class NumberOfIslandsII {

    public static void main(String[] args) {
        NumberOfIslandsII app = new NumberOfIslandsII();
        int[][] positions = new int[][]{
                {0, 1},
                {0, 2},
                {0, 3},
                {0, 4},
                {0, 5},
                {0, 0}
        };
        // app.numIslands2(1, 10, positions);
        // app.root(0);
        findIsland(new int[] {1,2,3,4,5,6,7,8,8}, 0);
    }

    public static int findIsland(int[] roots, int id) {
        while(id != roots[id]) {
            roots[id] = roots[roots[id]];   // only one line added
            id = roots[id];
            log.info(Arrays.toString(roots));
        }
        return id;
    }


    private int[] islands; // = new int[]{1,2,3,4,5,5};
    public int root(int island) {
        while (islands[island] != island) {
            islands[island] = islands[islands[island]];
            island = islands[island];
        }
        // log.info(Arrays.toString(islands));
        return island;
    }

    private int[] yo = {-1, 1, 0, 0};
    private int[] xo = {0, 0, -1, 1};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        islands = new int[m * n];
        Arrays.fill(islands, -1);
        int island = 0;
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            int y = positions[i][0];
            int x = positions[i][1];
            int id = y * n + x;
            islands[id] = id;
            island++;
            for (int j = 0; j < 4; j++) {
                int ny = y + yo[j];
                int nx = x + xo[j];
                int nid = ny * n + nx;
                if (ny >= 0 && ny < m && nx >= 0 && nx < n && islands[nid] != -1) {
                    int root = root(nid);
                    if (root != id) {
                        islands[root] = id;
                        island--;
                    }
                }
            }
            nums.add(island);

            log.info("island list: {}", Arrays.toString(islands));
        }
        return nums;
    }
}