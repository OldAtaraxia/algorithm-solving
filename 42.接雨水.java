import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while(left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax >= rightMax) {
                ans += (rightMax - height[right]);
                right--;
            } else {
                ans += (leftMax - height[left]);
                left++;
            }
        }
        return ans;
    }
}
// @lc code=end

