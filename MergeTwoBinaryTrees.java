/*
617. Merge Two Binary Trees

 Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:

Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7

Note: The merging process must start from the root nodes of both trees.

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null)
            return t2;
        else if(t2==null)
            return t1;
        else
        {
            TreeNode temp=new TreeNode(t1.val+t2.val);
            temp.left=mergeTrees(t1.left,t2.left);
            temp.right=mergeTrees(t1.right,t2.right);
            return temp;
        }
        
    }
}

/*
Time Complexity - O(n+m) where n=no of nodes in t1, m =no of nodes in t2
or O(x) where x is common nodes in t1 and t2.

Space complexity - O(h) where h is the height of the common tree
In recursive stack ... At most h nodes are going to be stored at a time
In worst case (linear trees) that will be O(m) where m is number of nodes in smaller tree

*/
