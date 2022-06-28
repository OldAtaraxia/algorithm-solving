/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int i = start, j = end;
        int x = nums[(i + j) / 2];
        // System.out.println(nums[(i + j) / 2]);
        
        while (i <= j) {
            while (i <= j && nums[i] > x) {
                i++;
            }

            while (i <= j && nums[j] < x) {
                j--;
            }

            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        System.out.println("now i == " + i + " and j == " + j);
        if (start + k - 1 <= j) {
            return quickSelect(nums, start, j, k);
        }

        if (start + k - 1 >= i) {
            return quickSelect(nums, i, end, k - (i - start));
        }

        return nums[j + 1];
    }
}
// @lc code=end

