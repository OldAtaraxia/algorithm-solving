/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        // 相当于找小于nums[0]的第一个位置
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[0]) right = mid;
            else left = mid + 1;
        }
        return left == nums.length ? nums[0] : nums[left];
    }
}
// @lc code=end

