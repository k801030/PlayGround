package my.play.ground;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Slf4j
public class MergeSortApp {
    public static void main(String[] args) {
        MergeSortApp app = new MergeSortApp();
        int[] nums = new int[]{3,4,1,2,5,7,8,0,6};
        app.sort(nums);
        log.info("{}", nums);
    }

    public void sort(int[] nums) {
        Queue<List<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(new ArrayList<>(nums[i]));
        }

        while (queue.size() != 1) {
            int size = queue.size();
            List<Integer> a = queue.poll();
            List<Integer> b = queue.poll();
            mergeTwoList(a, b);
        }
    }

    private void mergeTwoList(List<Integer> a, List<Integer> b) {

    }

    private int partition(int left, int right) {
        return left + (right - left) / 2;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = partition(left, right);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }
}
/*

[1,3,5,2,4,6]
 */