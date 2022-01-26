/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode current = dummyHead;
        while(current.next != null&& current.next.next != null) {
            ListNode node1 = current.next, node2 = current.next.next;
            node1.next = node2.next;
            node2.next = node1;
            current.next = node2;
            current = node1;
        }
        return dummyHead.next;
    }
}
// @lc code=end

