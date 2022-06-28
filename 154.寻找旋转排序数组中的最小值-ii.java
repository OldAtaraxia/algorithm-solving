/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        // 左半部分的元素 >=nums[0], 右半部分的元素 <= nums[0], 还有升序的约束条件
        int left = 0, right = nums.length;
        while (left < right) {
            // System.out.println("left == " + left + " and right == " + right);
            int mid = (left + right) / 2;
            if (nums[mid] < nums[0]) right = mid;
            else if (nums[mid] > nums[0]) left = mid + 1;
            else {
                // nums[mid] == nums[0]
                // nums[left]和nums[right]中一定有一个与nums[mid]相等
                if (nums[left] == nums[mid]) left++;
                else right--;
            }
        }
        if (left == nums.length) {
            return nums[0];
        }
        return nums[left];
    }
}
// @lc code=end

