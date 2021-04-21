package my.play.ground;

import com.google.common.collect.Lists;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // topKFrequent(new int[]{1, 2, 3, 5, 6, 6}, 3);
        int[][] ans = covertToArray();
        System.out.println(ans[0]);

        System.out.println(Arrays.asList(5));
        System.out.println(Lists.newArrayList(5));
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> 0);
    }

    static int[][] covertToArray() {
        List<int[]> ints = new ArrayList<>();
        ints.add(new int[1]);

        int[][] ans = new int[ints.size()][];
        return ints.toArray(ans);
    }

    static void process(String s, List<String> list) {
        // System.out.println(System.identityHashCode(s));
        list.add(s);
        s = "";

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        maxHeap.poll();
    }

    static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int a = Integer.MIN_VALUE;
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) minHeap.poll();
        }


        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll().getKey();
        }
        return ans;
    }

    void sort(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    }
}
