/*
965. Univalued Binary Tree

https://leetcode.com/problems/univalued-binary-tree/description/

Idea - Use DFS approach to traverse the nodes in the tree
Use the root value in the logic method. In the logic method, if the root value matches val, call the childs recursively, else return false


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
        if(root==null)
            return true;
        return logic(root,root.val);
    }
    public boolean logic(TreeNode root, int val)
    {
        if(root==null)
            return true;
        if(root.val!=val)
            return false;
        return logic(root.left,val) && logic(root.right,val);
    }
}
/*
Time Complexity - O(n) where n is number of nodes in the tree
Space Complexity - O(h) = O(n) in case of skewed tree as height of the tree h=n in case of a skewed tree
*/
