/*
this link might help
https://www.youtube.com/watch?v=zbozWoMgKW0

142. Linked List Cycle II

https://leetcode.com/problems/linked-list-cycle-ii/description/

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

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
public class Solution {
    public ListNode detectCycle(ListNode head) {
//         if(head==null || head.next==null)
//             return null;
//         ListNode slow=head;
//         ListNode fast=head.next;
//         while(slow!=fast)
//         {
//             if(fast==null || fast.next==null)
//                 return null;
//             else
//             {
//                 slow=slow.next;
//                 fast=fast.next.next;
//             }
//         }
//         System.out.println(fast.val);
//         fast=fast.next;
//         int cycleLength=0;
//         while(slow!=fast)
//         {
//             fast=fast.next;
//             cycleLength++;
//         }
//         cycleLength++;
//         System.out.println("cycle:"+cycleLength);
//         slow=head;
//         int count=0;
//         while(true)
//         {
//             count++;
//             ListNode temp=slow;
//             for(int i=0;i<cycleLength;i++)
//             {
//                 slow=slow.next;
//             }
//             if(temp==slow)
//                 break;
//         }
//         count--;
//         System.out.println(count);
//         slow=head;
//         for(int i=0;i<count;i++)
//         {
//             slow=slow.next;
//         }
//         for(int i=0;i<cycleLength;i++)
//         {
//             for(int j=0;j<cycleLength;j++)
//             {
//                 fast=fast.next;
//                 if(slow==fast)
//                     return slow;
//             }
//             slow=slow.next;
            
//         }
//         return slow;
        
        
        if(head==null || head.next==null)
            return null;
        else
        {
            ListNode slow=head;
            ListNode fast=head;
            while(true)
            {
                if(fast==null || fast.next==null)
                    return null;
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast)
                    break;
            }
            slow=head;
            while(slow!=fast)
            {
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
        
    }
}
/*
Time Complexity - O(n) - Elements are traversed once to find if cycle is present or not . If cycle is present, then little traversal to find the first element in the cycle.
Space Complexity - O(1)
*/
