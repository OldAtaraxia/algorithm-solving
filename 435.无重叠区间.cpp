/*
 * @lc app=leetcode.cn id=435 lang=cpp
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
public:
    static bool cmp(vector<int>& a, vector<int>& b) {
        return a[1] == b[1] ? a[0] < b[0] : a[1] < b[1];
    }
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        if(intervals.size() <= 1) return 0;
        sort(intervals.begin(), intervals.end(), cmp);
        int res = 0;
        int cnt = 1, last = 0;
        while(cnt < intervals.size()) {
            if(intervals[last][1] <= intervals[cnt][0]) {
                // cout << "save " << intervals[cnt][0] << " " << intervals[cnt][1] << endl;
                last = cnt;
                cnt++;
            } else {
                // cout << "remove " << intervals[cnt][0] << " " << intervals[cnt][1] << endl;
                res ++;
                cnt++;
            }
        }
        return res;
    }
};
// @lc code=end

