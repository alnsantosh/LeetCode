/*
543. Diameter of Binary Tree

 Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree

          1
         / \
        2   3
       / \     
      4   5    

Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them. 
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
General Idea: For each node, calculate the height of left subtree and right subtree. Compare this sum of left+right height with the d and update the diameter d accordingly. 
For each node, return the max of height of left and right subtree.Before returning this compute and update the value of d accordingly
*/
class Solution {
    int d=Integer.MIN_VALUE;//This global variable is used to store the diameter of the tree
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        logic(root);   
        return d-2;//For leaf nodes 1+logic(leaf_node.left)=1+logic(null)=1,similarly 1+logic(leaf_node.right)=1+logic(null)=1. However leaf nodes have 0 height. So when I do d=left+right, I am adding additional 2 to the actual value of height. Hence I am subtracting that value.
    }
    public int logic(TreeNode root)
    {
        if(root==null)
            return 0;
        else
        {
            int left=1+logic(root.left);//If root is not null, do incremented returns to calculate height.
            int right=1+logic(root.right);
            if(right+left>d)
            {
                d=right+left;
            }
            return Math.max(left,right);
        }
    }
}
/*
Time Complexity - O(n)- since dfs approach wherein all the elements are traversed.
Space Complexity - O(h) - h is height of tree. For skewed trees(worst case), the space complexity will be O(n) since all the nodes have 1 child except leaf node.
*/
