/*
563. Binary Tree Tilt

Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:

Input: 
         1
       /   \
      2     3
Output: 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1

Note:

    The sum of node values in any subtree won't exceed the range of 32-bit integer.
    All the tilt values won't exceed the range of 32-bit integer.

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
Idea : Calculate the sum of left and right child and return that to root in order to evaluate tilt.This is done in logic() function. I have used logic function because I have to return tilt, not the sum of child subtrees. However we need the child subtree sum.
So logic() function returns the sum of val of childs+val of itself
I have taken a global variable tilt to store the sum of tilts as we proceed in recursion.
*/

class Solution {
    int tilt=0;
    public int findTilt(TreeNode root) {
        logic(root);
        return tilt;
        
    }
    
    public int logic(TreeNode root)
    {
        if(root==null)
            return 0;
        else if(root.left==null && root.right==null) //This elase if condition is not required..look with an example
        {
            //tilt+=root.val;
            System.out.println("root.val: "+root.val+" tilt:"+tilt);
            return root.val;
            
         }   
        else //check if 
        {
            int left=logic(root.left);
            int right=logic(root.right);
            tilt+=Math.abs(left-right);
            System.out.println("left: "+left+" right: "+right+" tilt:"+tilt);
            return left+right+root.val;
        }
    }
}
/*
Time COmplexity - O(n)
Space Complexity - O(h)
*/
