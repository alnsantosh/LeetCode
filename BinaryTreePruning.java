/*
814. Binary Tree Pruning

https://leetcode.com/problems/binary-tree-pruning/description/

We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)

Example 1:
Input: [1,null,0,0,1]
Output: [1,null,0,null,1]
 
Explanation: 
Only the red nodes satisfy the property "every subtree not containing a 1".
The diagram on the right represents the answer.


Example 2:
Input: [1,0,1,0,0,0,1]
Output: [1,null,1,null,1]



Example 3:
Input: [1,1,0,1,1,0,1,0]
Output: [1,1,0,1,1,null,1]



Note:

    The binary tree will have at most 100 nodes.
    The value of each node will only be 0 or 1.


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
    public TreeNode pruneTree(TreeNode root) {
        if(root==null)
            return null;
        else
        {
            logic(root);
        }
        return root;
    }
    public boolean logic(TreeNode root)
    {
        // if(root==null)
        //     return false;
        if(root.left==null && root.right==null && root.val==0)//leaf node with values 0,return false
            return false;
        else if(root.left==null && root.right==null && root.val==1)//leaf node with value 1 , return 1
            return true;
        else
        {
            boolean left=false,right=false;//by default false, since if root.left==null or root.right==null, the corresponding boolean value should return false
            if(root.left!=null)//if child is not null, prune recursively
                left=logic(root.left);
            if(root.right!=null)
                right=logic(root.right);
            if(!left)//left=true means atleast one of the node in the child has val=1
                root.left=null;
            if(!right)
                root.right=null;
            return (left||right) || root.val==1;//if both left and right are false, then we have to check the value of current root val. If it is 1, then rwe do not prune it, else we prune the current node
            
        }
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(h)
*/
