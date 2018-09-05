/*
124. Binary Tree Maximum Path Sum

https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        logic(root);
        return max;
    }
    public int logic(TreeNode root) {
        if(root==null)
            return 0;
        // if(root.left==null && root.right==null)
        // {
        //     if(root.val>max)
        //     {
        //         max=root.val;
        //         return root.val;
        //     }
        // }
        int p=logic(root.left);
        int q=logic(root.right);
        
        if(p+q+root.val>max)//logic for calculating the max value
        {
            max=p+q+root.val;
        }
        if(root.val>max)
            max=root.val;
        if(root.val+p>max)
            max=root.val+p;
        if(root.val+q>max)
            max=root.val+q;
        
        if(p<0 && q<0)//logic for value to return
        {
            
            return root.val;   
        }
        if(p>q)
            return p+root.val;
        else
            return q+root.val;
        
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
