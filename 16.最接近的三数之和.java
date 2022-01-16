import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = (int) (1e9 + 7);
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            while(j < k) {
                int sum = nums[j] + nums[k] + nums[i];
                if(Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }

                if(sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    ans = sum;
                    break;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

