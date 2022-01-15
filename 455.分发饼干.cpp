/*
 * @lc app=leetcode.cn id=455 lang=cpp
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        // 避免出现把大饼干给了胃口小的孩子
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int res = 0;
        int i = 0, j = 0;
        while(i < g.size() && j < s.size()) {
            if(g[i] <= s[j]) {
                res++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return res;
    }
};
// @lc code=end

