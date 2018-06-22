/*
538. Convert BST to Greater Tree

Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13


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
    int total=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null)
            return null;
        // else if(root.left==null && root.right==null)
        // {
        //    //total+=root.val;
        // }
        else
        {
            convertBST(root.right);
            total+=root.val;
            root.val=total;
            convertBST(root.left);
        }
        
        return root;
                
    }
    
}
/*
Time Complexity - O(n)
Space Complexity - O(h)
*/
