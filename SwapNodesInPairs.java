/*
24. Swap Nodes in Pairs

https://leetcode.com/problems/swap-nodes-in-pairs/description/

Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
take prev,head,next nodes and make the links accordingly
*/
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode res=null,prev=null;
        boolean flag=true;
        if(head==null || head.next==null)
            return head;
        while(head!=null && head.next!=null)
        {
            //System.out.println(head.val);
            ListNode next=head.next;
            //System.out.println(next.val);
            head.next=next.next;
            next.next=head;
            if(prev!=null)
            {
                prev.next=next;
            }
            if(flag)
            {
                flag=false;
                res=next;
            }
            prev=head;
            head=head.next;
        }
        return res;
    }
}
/*
Time Complexity - O(n)
Space Coplexity - O(1)
*/
