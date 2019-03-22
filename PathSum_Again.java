/*
112. Path Sum

https://leetcode.com/problems/path-sum/description/

Idea -- Use recursion to perform DFS.


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
 /**/
 /**/
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        sum-=root.val;
        if(sum==0 && root.left==null && root.right==null)
            return true;
        boolean left=hasPathSum(root.left,sum);
        //System.out.println("root: "+root.val+"left: "+left);
        boolean right=hasPathSum(root.right,sum);
        //System.out.println("root: "+root.val+"right: "+right);
        return left || right;
    }
}

/*
Time Compelxity - O(n) where n is the number of nodes. O(n) complexity as all the nodes are traversed in worst case for finding the appropriate path
Space Complexity - O(h) = O(n) in case of a skewed tree. At any instant, the recursive stack will contain atmost h number of nodes in ot where h is the height of the tree which is equal to log(n) in general. However, in case of skewed tree, h=n.
*/
