/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        if(s == null) {
            return false;
        }

        int left = 0, right = s.length() - 1;
        while(left < right) {
            while (left < right && !isValid(s.charAt(left))) {
                left++;
            } 
            while (left < right && !isValid(s.charAt(right))) {
                right--;
            }

            if (left < right && !isEqual(s.charAt(left), s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

    boolean isEqual(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }
}
// @lc code=end

