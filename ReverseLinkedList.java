/*
206. Reverse Linked List

https://leetcode.com/problems/reverse-linked-list/description/

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

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
        ListNode prev=null,curr=null;
        while(head!=null)
        {
            curr=head.next;
            head.next=prev;
            prev=head;
            head=curr;
        }
        return prev;
        
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
