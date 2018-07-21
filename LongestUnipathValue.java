/*
687. Longest Univalue Path

https://leetcode.com/problems/longest-univalue-path/description/

Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5

Output:

2

Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5

Output:

2

Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000. 
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
Basic Idea - Recursive approach. we calculate left and right sum. We return the max of left and right to the parent call.However we update max at every function call. If one of left or right is 0, then find bigger value between amx,left or right. If left and right are both greater than 0, we find bigger value between max,left+right.
*/
class Solution {
    int max=Integer.MIN_VALUE;
    public int longestUnivaluePath(TreeNode root) {
        logic(root);
        return (max==Integer.MIN_VALUE)?0:max;
    
    }
    
    public int logic(TreeNode root) {
        if(root==null)
            return 0;
        else
        {
            int left=0,right=0,count=0;
            if(root.left!=null && root.left.val==root.val)
            {
                left+=1+logic(root.left);
            }
            else
            {
                logic(root.left);
            }
            
            if(root.right!=null && root.right.val==root.val)
            {
                right+=1+logic(root.right);
            }
            else
            {
                //count=0;
                logic(root.right);
            }
            count=Math.max(left,right);
            //System.out.println(count);
            if(count>max)
                max=count;
            if(left>0 && right>0)
                max=Math.max(max,left+right);
            return count;
        }
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n) - Implicit stack - Worst case when we have skewed tree, then all the nodes in the tree will be in the stack. In that case O(n) space complexity
*/
