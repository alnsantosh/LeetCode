/*
110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

    a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7

Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4

Return false.

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
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        else
        {
            return logic(root)!=-1;
            
        }
        
    }

    public int logic(TreeNode root)//at every node check if leftsubtree height-rightsubtree height>1. If the condition satisfies, return -1. Else return height of the subtrees. So finally if returned value is -1, then difference between subtrees height >1, else tree is balanced
    {
        if(root==null)
            return 0;
        else
        {
            int left=1+logic(root.left);
            int right=1+logic(root.right);
            //System.out.println("Left: "+left+" Right: "+right+" Diff:"+(left-right));
            if(left==0 || right==0)
                return -1;
            if(left-right>1 || left-right<-1)
                return -1;
            else
                return (Math.max(right,left));
        }
        //return count;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(h)
*/
