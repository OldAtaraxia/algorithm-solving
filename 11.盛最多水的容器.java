/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = (r - l) * Math.min(height[l], height[r]);
        while(l < r) {
            if(height[l] < height[r]) l++;
            else r--;
            ans = Math.max(ans, (r - l) * Math.min(height[l], height[r]));
        }
        return ans;
    }
}
// @lc code=end

