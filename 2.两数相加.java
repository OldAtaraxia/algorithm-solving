/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0; // 进位
        while (l1 != null || l2 != null || carry != 0) {
            int p1 = (l1 == null ? 0 : l1.val);
            int p2 = (l2 == null ? 0 : l2.val);
            if(head == null) {
                head = new ListNode((p1 + p2 + carry) % 10);
                tail = head;
            } else {
                tail.next = new ListNode((p1 + p2 + carry) % 10);
                tail = tail.next;
            }
            carry = (p1 + p2 + carry) / 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return head;
    }
}
// @lc code=end

