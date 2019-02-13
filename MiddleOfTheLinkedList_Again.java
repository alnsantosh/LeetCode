
/*
876. Middle of the Linked List

https://leetcode.com/problems/middle-of-the-linked-list/description/

Idea - Used two pointers approach. Move the fast pointer two steps at a time and the slow pointer one step at a time. Break the loop when the fast pointer reaches the end of the linked list. Now the slow pointer will be pointing to the middle of the linked list.


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
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            // if(slow!=null)
            // {
            //     slow=slow.next;
            // }
            // else
            // if(fast!=null && fast.next!=null)
            // {
            //     fast=fast.next.next;
            // }
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}

/*
Time Complexity - O(n/2)= O(n) where n is number of nodes in the linked list
Space Complexity - O(1)
*/
