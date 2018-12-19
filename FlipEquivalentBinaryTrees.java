/*
951. Flip Equivalent Binary Trees

https://leetcode.com/problems/flip-equivalent-binary-trees/description/

For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.

A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.

Write a function that determines whether two binary trees are flip equivalent.  The trees are given by root nodes root1 and root2.

 

Example 1:

Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
Output: true
Explanation: We flipped at nodes with values 1, 3, and 5.
Flipped Trees Diagram
 

Note:

Each tree will have at most 100 nodes.
Each value in each tree will be a unique integer in the range [0, 99].
*/
/*
Idea - Recursive approach
Check the root node values. If matches, then for the recursive step to be correct either values need to match without flipping i.e., (flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right)) or values need to match after flipping,i.e, (flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left))
Any of the above cases has to be true, else we return false
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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)
            return true;
        else if(root1==null || root2==null)
            return false;
            
        if(root1.val!=root2.val)
        {
            return false;
        }
        if(root1.val==root2.val && root1.left==null && root1.right==null && root2.left==null && root2.right==null)
            return true;
        else
        {
            //if(root1.left.val==root2.left.val && root1.right.val==root2.right.val)
            {
                return (flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right)) || (flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left));
            }
            //else
            //{
            //    return flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left);
            //}
        }
            
        
    }
}
/*
Time Complexity - O(4^n) - Consider the recursion as a tree with 4 braches to each node
Space Complexity - O(h) = O(n) since in case of skewed tree, h=n. In case of rexursion, space complexity os equal to the height of the recursion tree.
*/
