/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left < right) {
            System.out.println("now left == " + left + " and right == " + right);
            int mid = (left + right) / 2;
            if ((long)mid * mid >= num) right = mid;
            else left = mid + 1;
        } 
        return left * left == num;
    }
}
// @lc code=end

