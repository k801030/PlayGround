package my.play.ground;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuickSortApp {
    public static void main(String[] args) {
        QuickSortApp app = new QuickSortApp();
        int[] nums = new int[]{3,4,1,2,5,7,8,0,6};
        app.sort(nums);
        log.info("{}", nums);
    }

    public void sort(int[] nums) {
        innerQuickSort(nums, 0, nums.length - 1);
    }

    private void innerQuickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = partition(nums, left, right);
        innerQuickSort(nums, 0, pivot - 1);
        innerQuickSort(nums, pivot + 1, right);
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int rightPointer = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[rightPointer];
                nums[rightPointer] = temp;
                rightPointer++;
            }
        }
        int temp = nums[right];
        nums[right] = nums[rightPointer];
        nums[rightPointer] = temp;
        return rightPointer;
    }
}

/*
[3,1,2]
 */