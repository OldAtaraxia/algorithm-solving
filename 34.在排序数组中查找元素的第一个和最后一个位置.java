/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = searchFirst(nums, target), last = searchFirst(nums, target + 1) - 1;
        System.out.println(first + " " + last);
        if (first >= 0 && first < nums.length && last >= 0 && last < nums.length 
            && nums[first] == target && nums[last] == target) {
                return new int[] {first, last};
            } else {
                return new int[] {-1, -1};
            }
    }

    // 找第一个位置, 也就是找大于等于target的第一个元素
    private int searchFirst(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
// @lc code=end

