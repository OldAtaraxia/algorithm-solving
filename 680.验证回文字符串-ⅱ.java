/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean validPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}
// @lc code=end

