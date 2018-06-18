/*
669. Trim a Binary Search Tree

 Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:

Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2

Example 2:

Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1

*/

/*
General idea: If the root value is greater than R, then trim right subtree.If the root value is greater than L, then trim left subtree.Else trim left and right childs of the root.
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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null)
            return null;
        else if(root.val>R)
            return trimBST(root.left,L,R);
        else if(root.val<L)
            return trimBST(root.right,L,R);
        else if(root.val==L)
        {
            root.left=null;
            root.right=trimBST(root.right,L,R);
        }
        else if(root.val==R)
        {
            root.right=null;
            root.left=trimBST(root.left,L,R);
        }
        else
        {
            root.left=trimBST(root.left,L,R);
            root.right=trimBST(root.right,L,R);
        }
        return root;  
    }
}
/*
[3,0,4,null,2,null,null,1]
1
3

Nice test case
*/
/*
Time Complexity - O(n) -  n=no.of nodes in the tree
Space Complexity - O(h), h=height of the tree
*/
