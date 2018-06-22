/*
671. Second Minimum Node In a Binary Tree

 Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:

Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.

Example 2:

Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.

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
    int s_min=Integer.MAX_VALUE,min=Integer.MAX_VALUE;//considering two global variables
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null)
            return 0;
        else
        {
            if(root.val<min)//if value less than min
            {
                min=root.val;
            }
            else if(root.val<s_min && root.val>min)//if value >min and <s_min
            {
                s_min=root.val;
            }

            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
            
        }
        
        if(s_min==Integer.MAX_VALUE)//if s_min value is unchanged, then it means that tree has all the same valued nodes.
            return -1;
        return s_min;
        
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(h)
*/
