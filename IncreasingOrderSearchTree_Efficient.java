/*
897. Increasing Order Search Tree

https://leetcode.com/problems/increasing-order-search-tree/description/

Idea - Instead of storing all the element of the tree in the list, we can do the appropriate linking and delinking on the fly in inOrder() method.

Inspired from
https://leetcode.com/problems/increasing-order-search-tree/solution/
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
    TreeNode t;
    public TreeNode increasingBST(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))
            return root;
        t=new TreeNode(-1);
        TreeNode res=t;
        inOrder(root);
        return res.right;
    }
    public void inOrder(TreeNode root)
    {
        if(root==null)
            return;
        inOrder(root.left);
        root.left=null;
        t.right=root;
        //t.left=null;
        t=root;
        inOrder(root.right);
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(h)=O(n) since height of tree(h)=no. of nodes in tree(n) in case of skewed tree
*/
/*
*/
