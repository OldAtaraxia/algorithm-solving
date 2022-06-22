/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        // 朴素的想法是先二分找到分割点...
        int left = 0, right = nums.length - 1;
        while (left < right) {
            System.out.println("now left == " + left + " and right == " + right);
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                // left -> mid是有序的
                if (nums[left] <= target && target <= nums[mid]) {
                    // 在 left -> mid里找
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // mid -> right是有序的
                if (nums[mid] < target && target <= nums[right]) {
                    // 在mid -> right中找
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        System.out.println("now left == " + left + " and right == " + right);
        return nums[left] == target ? left : -1;
    }
}
// @lc code=end
