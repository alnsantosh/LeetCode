/*
160. Intersection of Two Linked Lists

https://leetcode.com/problems/intersection-of-two-linked-lists/description/

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
Credits:
Special thanks to @stellari for adding this problem and creating all test cases.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        ListNode l1=headA,l2=headB;
        while(l1!=l2)
        {
            if(l1==null)
            {
                l1=headB;
            }
            else
            {
                l1=l1.next;
            }
            if(l2==null)
            {
                l2=headA;
            }
            else
            {
                l2=l2.next;
            }
            
            
        }
        return l1;
    }
}
/*
Time Complexity - O(2*n) = O(n) (2*n in worst case where both the linked list are not connected. In that case each element is visited twice)
Space Complexity - O(1)
*/
