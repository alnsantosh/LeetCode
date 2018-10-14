/*
112. Path Sum

https://leetcode.com/problems/path-sum/description/

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
Call the function recursively and check if at the leaf node, the sum==0. Based on that return true or false accordingly.
*/
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)//base case
            return false;
        if(root.left==null && root.right==null)//leaf node
            return sum-root.val==0;
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);//for non-leaf nodes
    }
}
/*
Time Complexity - O(n) - Since all the elements are traversed
Space Complexity - O(n) - In case of skewed tree. In general O(h).. Basically the amount of elements present in a recursive stack at any point of time
*/
