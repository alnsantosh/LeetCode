/*
965. Univalued Binary Tree

https://leetcode.com/problems/univalued-binary-tree/description/

Idea - Recursively traverse through all the elements of the array and compare the value. If value doesn't match anywhere, return false;
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
    public boolean isUnivalTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))
            return true;
        int val=root.val;
        return logic(root,val);
    }
    public boolean logic(TreeNode root,int val)
    {
        if(root==null)
            return true;
        if(root.val==val)
        {
            return (logic(root.left,val) && logic(root.right,val));
        }
        else
        {
            return false;
        }
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(h)=O(n) in case of a skewed tree
*/
/**/
