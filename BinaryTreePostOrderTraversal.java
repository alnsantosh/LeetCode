/*
145. Binary Tree Postorder Traversal

https://leetcode.com/problems/binary-tree-postorder-traversal/description/

Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?
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
/*
Idea - Recursive approach
*/
class Solution {
    List<Integer> res=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null)
            return res;
        logic(root);
        return res;
        
    }
    public void logic(TreeNode root)
    {
        if(root==null)
            return;
        logic(root.left);
        logic(root.right);
        res.add(root.val);
    }
}
/*
Time Complexity - O(n) - Since we are iterating through all the elements of the tree
Space Complexity - O(n) - Recursive stack
*/
