/*
19. Remove Nth Node From End of List

https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?

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
Idea - The problem can be solved using 2 pointers. Traverse the first pointer till n+1 th element. Then traverse both the pointers together till the first pointer reaches end. Now, the secong pointer will be pointing to the node whose next node needs to be deleted.
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev=head,head2=head;
        for(int i=0;i<=n;i++)
        {
            head=head.next;
            if(head==null)
            {
                if(i<n)
                    return head2.next;
            }
        }
        while(head!=null)
        {
            head=head.next;
            prev=prev.next;
        }
        prev.next=prev.next.next;
        return head2;
    }
}
/*
Time Complexity - O(n) - single pass
Space Complexity - O(1)
*/
