/*
2. Add Two Numbers

https://leetcode.com/problems/add-two-numbers/description/

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
            return null;
        else if(l1==null)
            return l2;
        else if(l2==null)
            return l1;
        ListNode res=new ListNode(0);
        int carry=0;
        boolean start=false;
        ListNode fin=null,prev=null;
        while(l1!=null || l2!=null)
        {
            //System.out.println(l1.val+" "+l2.val);
            int sum=0;
            if(l1!=null)
            {
                sum+=l1.val;
            }
            if(l2!=null)
            {
                sum+=l2.val;
            }
            sum+=carry;
            carry=0;
            if(sum>=10)
            {
                sum-=10;
                carry=1;
            }
            res.val=sum;
            if(!start)
            {
                start=true;
                fin=res;
            }
            ListNode next=new ListNode(0);
            res.next=next;
            prev=res;
            res=res.next;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }
        if(carry==1)
        {
            res.val=carry;
        }
        else
            prev.next=null;
        return fin;
        
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n) - Cosidering the output list, can be done in O(1)
*/
