import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < n - 2; i++) {
            if(nums[i] > 0) break; 
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while(j < k) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if(nums[j] + nums[k] + nums[i] < 0) j++;
                else if (nums[i] + nums[j] + nums[k] > 0) k--;
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    j++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

