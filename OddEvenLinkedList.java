/*
328. Odd Even Linked List

https://leetcode.com/problems/odd-even-linked-list/description/

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL

Note:

    The relative order inside both the even and odd groups should remain as it was in the input.
    The first node is considered odd, the second node even and so on ...


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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode odd=head,even=head.next;
        ListNode tempO=odd;//tempO stores the begginning of odd
        ListNode tempE=even;//tempE stores the begginning of even
        while(true)
        {
            if(even==null)//This condition is satisified for odd length linked list
                break;
            odd.next=odd.next.next;
            if(even.next==null)//This condition is satisfied for even length linked list
                break;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
            
            
        }
        odd.next=tempE;
        return tempO;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
