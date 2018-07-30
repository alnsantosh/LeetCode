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
        ListNode res=new ListNode(0);
        ListNode temp=null,prev=null;//temp is to store the initial address of the res linked list and hence can be returned at the end,prev is to store previous node of res everytime.  prev is used because at the end of below while loop, say if the carry=0, then we need previous node to make its next as null or else an additional 0 will be appended to the output.
        int sum=0,carry=0;
        boolean first=true;
        while(l1!=null || l2!=null)
        {
            if(l1!=null)//ensuring nullpointer exception doesn't come
                sum+=l1.val;
            if(l2!=null)
                sum+=l2.val;
            //System.out.println(sum+" "+carry);
            sum+=carry;//add carry to sum everytime 
            carry=0;
            if(sum>=10)
            {
                sum-=10;
                carry+=1;
            }
            res.val+=sum;
            sum=0;
            if(first)//logic to store the initial address of the res linked list for returning the dsired solution
            {
                first=false;
                temp=res;
            }
            res.next=new ListNode(0);
            prev=res;
            res=res.next;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }
        //System.out.println(res.val);
        if(carry>0)//edge case, make sure carry is 0 at the end, if not use a new node to store this value and point at the end.
            res.val+=carry;
        else
            prev.next=null;
        return temp;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n) as I am creating an resultant linked list.
*/
