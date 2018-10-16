/*
111. Minimum Depth of Binary Tree

https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
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
Idea - Use recursive DFS approach
*/
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)//base case
            return  0;
        if(root.left==null && root.right==null)//condition for leaf node
            return 1;
        
        if(root.right==null)//if only left child is present
            return 1+minDepth(root.left);
        else if(root.left==null)//if only right child is present
            return 1+minDepth(root.right);
        else//if both the childs are present for the root node
        {
            int left=1+minDepth(root.left);
            int right=1+minDepth(root.right);
            if(left>right)
                return right;
            else
                return left;
        }
        
        
    }
}
/*
Time Complexity - O(n) - Since all the elements of the tree are traversed
Space Complexity - O(n) in case of skewed matrix - The space consumed by the recursive stack
*/
