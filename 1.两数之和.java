import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    class Pair implements Comparable<Pair> {
        int number, index;

        public Pair(int number, int index) {
            this.number = number;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return number - o.number;
        }
    }

    private Pair[] getSortedPairs(int[] numbers) {
        Pair[] pairs = new Pair[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            pairs[i] = new Pair(numbers[i], i);
        }
        Arrays.sort(pairs);

        return pairs;
    }


    public int[] twoSum(int[] nums, int target) {
        int[] res = {-1, -1};

        if (nums == null) {
            return res;
        }

        Pair[] pairs = getSortedPairs(nums);
        int left = 0, right = nums.length - 1;
        while(left < right) {
            if(pairs[left].number + pairs[right].number > target) {
                right--;
            } else if(pairs[left].number + pairs[right].number < target) {
                left++;
            } else {
                res[0] = Math.min(pairs[left].index, pairs[right].index);
                res[1] = Math.max(pairs[left].index, pairs[right].index);
                break;
            }
        }
        return res;
    }
}
// @lc code=end

