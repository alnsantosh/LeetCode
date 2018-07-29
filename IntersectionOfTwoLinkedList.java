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

/*
Idea - Let x=distance from headA to common element, y=distance from headb to common element, z= distance from common element to the end of the linked list
When headA reach null, point it to the beginning of the other linked list (At this point the distance travelled = x+z)
When headB reach null, point it to the beginning of the other linked list (At this point the distance travelled = y+z)
When we continue moving forward they exa tly meet at the beginning of the intersection as headA would have travelled= x+z+y
Similarly headB would have travelled= y+z+x
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        ListNode tempA=headA,tempB=headB;
        while(headA!=headB)
        {
            if(headA!=null)
            {
                headA=headA.next;
            }
            else
            {
                headA=tempB;
            }
            if(headB!=null)
            {
                headB=headB.next;
            }
            else
            {
                headB=tempA;
            }
            // headA=headA==null?tempB:headA.next;
            // headB=headB==null?tempA:headB.next;
        }
        return headA;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
