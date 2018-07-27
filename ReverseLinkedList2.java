/*
92. Reverse Linked List II

https://leetcode.com/problems/reverse-linked-list-ii/description/

Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL


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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null)//if head is null or only 1 element is present, then there is no need to compute anything
            return head;
        ListNode prevJoin=null,start=head;//prevJoin will be starting point which needs to be connected to reversed sublist eg: 1->2->3->4->5->null m=2,n=4 . In this case,prevJoin will be pointing at 1 which will be connected to 4 at the end. start stores the starting node which needs to be returned at the end. If 1st element is included in the reversal, then prevJoin will be null and start cannot be returned as we would have reverrsed it and it would be pointing to null.
        for(int i=1;i<m;i++)//traversing till the point where revrsing needs to be done
        {
            prevJoin=head;
            head=head.next;//At the end of loop, head will point to the first element from where reversal needs to be done
        }
        //System.out.println(prevJoin.val+" "+head.val);
        ListNode prev=null;
        ListNode reverseEnd=head;//reverseEnd will store the node of the tail of the reversed sublist. eg: In above example, it will store 2.
        
        for(int i=0;i<=n-m;i++)//logic to reverse the linked list inplace
        {
            ListNode temp=head.next;
            //System.out.println(head.val);
            head.next=prev;
            prev=head;
            head=temp;
        }
        if(prevJoin!=null)//if first element of linked list is not included in the reversal
        {
            prevJoin.next=prev;
            reverseEnd.next=head;
            return start;
        }
            
        else  // If first element is also included in the reversal, then the prevJoin which stores the previous value of the first reversal element will be null. Hence prev becomes the starting index.
        {
            prevJoin=prev;
            reverseEnd.next=head;
            return prevJoin;
        }
            
        
        
        
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
