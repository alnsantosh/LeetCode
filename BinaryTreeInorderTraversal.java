/*
94. Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]

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
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        inOrder(root,res);
        return res;
        
    }
    public void inOrder(TreeNode root,List<Integer> res)
    {
        if(root==null)
            return;
        else
        {
            inOrder(root.left,res);
            res.add(root.val);
            inOrder(root.right,res);
        }
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(h) - h is height of the tree
*/
