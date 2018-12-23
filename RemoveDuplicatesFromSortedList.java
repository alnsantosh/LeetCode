/*
83. Remove Duplicates from Sorted List

https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
*/
/*
Idea - Iterate through all the elements in the linked list, if the adjacent values are same, then make appropriate changes (Removing the duplicate element from the linked list) to the next pointer of current head.
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head;
        if(head==null || head.next==null)//Base case, If the head is null or if the head points to null, then we simply return the head
            return head;
        else
        {
            while(head.next!=null)
            {
                if(head.val==head.next.val)//If the head value and next elements' value are same, then we link the head to head.next.next. This way we are removing a duplicate element
                {
                    head.next=head.next.next;
                }
                if(head.next==null)//There is a chance we reach end after above opreation, so we do this check to make sure if we have reached end of the linked list. In that case, we break from the while loop
                {
                    break;
                }
                else if(head.val!=head.next.val)//Before incrementing the head pointer, we check if the head value and head.next value are different. If not, then we do not increment the head and the while loop continues.
                    head=head.next;
            }
        }
        return temp;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
