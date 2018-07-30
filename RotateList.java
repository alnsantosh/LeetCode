/*
61. Rotate List

https://leetcode.com/problems/rotate-list/description/

Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL

Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL


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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0)
            return head;
        if(head==null || head.next==null)
            return head;
        ListNode temp=head,prev=null;
        int n=0;
        while(temp!=null)
        {
            prev=temp;
            temp=temp.next;
            n++;
        }
        prev.next=head;
        k=k%n;
        if(k==0)
        {
            prev.next=null;
             return head;
        }
        for(int i=1;i<n-k;i++)
            head=head.next;
        ListNode temp2=head.next;
        head.next=null;
        return temp2;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
