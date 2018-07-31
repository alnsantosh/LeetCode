/*
109. Convert Sorted List to Binary Search Tree

https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5


*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        return logic(head,null);
    }
    public TreeNode logic(ListNode head,ListNode tail)
    {
        ListNode slow=head;
        ListNode fast=head;
        if(head==tail)//edge case
        {
            return null;
        }
            
        while(true)
        {
            if(fast==tail || fast.next==tail)
                break;
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode root=new TreeNode(slow.val);
        root.left=logic(head,slow);
        root.right=logic(slow.next,tail);
        return root;
    }
}

/*
Time Complexity - O(n^2)
Space Complexity - O(log(n)) - height of the BST will be log(n), since tree is height balanced
*/
