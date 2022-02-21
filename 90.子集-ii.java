import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, cur, ans);
        System.out.println(ans.toString());
        return new ArrayList<>(ans);
    }

    void dfs(int[] nums, int u, List<Integer> cur, Set<List<Integer>> ans) {
        if(u == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[u]);
        dfs(nums, u + 1, cur, ans);

        cur.remove(cur.size() - 1);
        dfs(nums, u + 1, cur, ans);
    }
}
// @lc code=end

