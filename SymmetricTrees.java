/*
101. Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3

Note:
Bonus points if you could solve it both recursively and iteratively. 
*/
**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return logic(root,root);
        
    }
    public boolean logic(TreeNode p,TreeNode q)//Since I have to see if the mirror image of tree is same as the original tree, it is easier to compare tree with itself.. i.e., consider two trees(with same nodes i.e., identical)
    {
        if(p==null && q==null)
            return true;
        else if(p==null || q==null)
            return false;
        else
        {
            if(p.val==q.val)// if values are same
                return logic(p.left,q.right) && logic(p.right,q.left);
            else
                return false;
        }
    }
}

/*
Time Complexity - O(n)
Space Complexity - O(h)
*/
