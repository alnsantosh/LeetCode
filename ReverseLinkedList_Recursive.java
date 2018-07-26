/*
206. Reverse Linked List

https://leetcode.com/problems/reverse-linked-list/description/

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:

A linked list can be reversed either i

teratively or recursively. Could you implement both?

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode current=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return current;
    }
}
/*
Time Complexity - O(n)
Spacce Complexity - O(1)
*/
