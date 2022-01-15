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
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i ++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if(stack.isEmpty()) break;
                else ans += (Math.min(height[i], stack.peek()) - height[top]) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return ans;
    }
}
// @lc code=end

