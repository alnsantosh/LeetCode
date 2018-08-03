/*
369. Plus One Linked List

https://www.lintcode.com/problem/plus-one-linked-list/description

Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
Example

Given head = 1 -> 2 -> 3 -> null, return 1 -> 2 -> 4 -> null.

*/
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*
Idea - Reverse the linked list. Add 1 to the number. Then again reverse the linked list.
*/
public class Solution {
    /**
     * @param head: the first Node
     * @return: the answer after plus one
     */
    public ListNode plusOne(ListNode head) {
        // Write your code here
        if(head==null)
        {
            return new ListNode(1);
        }
        head=reverse(head);
        ListNode prev=null,head2=head;
        int carry=1;
        while(head!=null)
        {
            if(carry==0)
                break;
            head.val+=carry;
            carry=0;
            if(head.val>=10)
            {
                head.val-=10;
                carry++;
            }
            prev=head;
            head=head.next;
        }
        if(carry==1)
        {
            prev.next=new ListNode(1);
        }
        return reverse(head2);
    }
    public ListNode reverse(ListNode head) //Reversing the linked list in place
    {
        ListNode prev=null;
        while(head!=null)
        {
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
