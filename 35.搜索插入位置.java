/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        return search(nums, target) + 1;
    }

    // 找到小于target的最后一个位置
    private int search (int[] nums, int target) {
        int left = -1, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] < target) left = mid;
            else right = mid - 1; 
        }
        return left;
    }
}
// @lc code=end

