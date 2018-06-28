/*
141. Linked List Cycle

https://leetcode.com/problems/linked-list-cycle/description/

 Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*
Idea: I have used two pointers to identify the cycles. First is the slow pointer which moves 1 step at a time,another is the fast pointer which moves 2 steps at a time. If there is cycle, then the fast pointer will reach the end i.e., the fast pointer will be pointing to a node where the node.next=null, meaning no cycle is present.
If cycle is present, then eventually the low pointer and high pointer will point to the same node. At that moment we return true
*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head==null || head.next==null)//Base condition. If head is null or only 1 element is present
            return false;
        ListNode slow=head;
        ListNode fast=head.next;
        while(slow!=fast)//since condition is slow!=fast, we cannot point both slow and fast to same node head.
        {
            if(fast==null || fast.next==null)// If there are no cycles, then the fast pointer will reach the end i.e., the fast pointer will be pointing to a node where the node.next=null(when it is pointing at last node), or node=null(when pointing to second last node and on jump goes to node.next.next which is null)
                return false;
            else//Increment the pointers accordingly
            {
                slow=slow.next;
                fast=fast.next.next;
            }
        }
        return true;
    }
}
/*
Time Complexity - O(n) when no cycles are present
O(N+K) = O(n) when cycles are present, N=no of non-cyclic nodes, K=no of cyclic nodes

Space Complexity - O(1), Since using only 2 pointers
*/
