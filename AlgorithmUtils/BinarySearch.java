package AlgorithmUtils;

public class BinarySearch {
    // 满足条件的第一个元素的下标
    public int binarySearchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) right = mid;
            else left = mid + 1;
        }
        return nums[left];
    }

    // 满足条件的最后一个元素的下标
    public int binarySearchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right + 1) / 2;
            if (check(mid)) left = mid;
            else right = mid - 1;
        }
        return nums[right];
    }
}
