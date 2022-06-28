/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n % 2 == 1) {
            // 中位数为n/2
            return getKthElement(nums1, nums2, n / 2 + 1);
        } else {
            return (double) (double)(getKthElement(nums1, nums2, n / 2) + (double)getKthElement(nums1, nums2, n / 2 + 1)) / 2;
        }
    }

    // 从两个数组中得到第k小的数
    public int getKthElement (int[] num1, int[] num2, int k) {
        int index1 = 0, index2 = 0;
        
        while (true) {
            // 若有数组为空那就返回另一个数组的第k个元素
            if (index1 == num1.length) return num2[index2 + k - 1];
            if (index2 == num2.length) return num1[index1 + k - 1];

            // 若k == 1那直接返回两个数组头元素的较小值
            if (k == 1) {
                return Math.min(num1[index1], num2[index2]);
            }

            // 正常情况
            // pivot = num[k/2 - 1]
            int newindex1 = Math.min(index1 + k / 2, num1.length) - 1;
            int newindex2 = Math.min(index2 + k / 2, num2.length) - 1;
            int pivot1 = num1[newindex1], pivot2 = num2[newindex2];
            // 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
            // 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
            if (pivot1 <= pivot2) {
                k -= (newindex1 - index1 + 1); // newindex1到index1的元素被删去了
                index1 = newindex1 + 1;
            } else {
                k -= (newindex2 - index2 + 1);
                index2 = newindex2 + 1;
            }
        }
    }
} 
// @lc code=end

