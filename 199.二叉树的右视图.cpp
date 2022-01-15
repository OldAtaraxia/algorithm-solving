/*
 * @lc app=leetcode.cn id=199 lang=cpp
 *
 * [199] 二叉树的右视图
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        return bfs(root);
    }
    vector<int> bfs(TreeNode* p) {
        vector<int> ans;
        if (p == nullptr) return ans;
        queue<pair<TreeNode*, int>> que;
        que.push(make_pair(p, 1));
        ans.push_back(p -> val);
        while(!que.empty()) {
            TreeNode* now = que.front().first;
            int order = que.front().second;
            que.pop();
            // 更新答案
            if(ans.size() == order) {
                ans[order - 1] = now -> val;
            } else {
                ans.push_back(now -> val);
            }
            if(now -> left != nullptr) {
                que.push(make_pair(now -> left, order + 1));
            }
            if(now -> right != nullptr) {
                que.push(make_pair(now -> right, order + 1));
            }
        }
        return ans;
    }

};
// @lc code=end
