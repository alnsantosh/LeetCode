/*
572. Subtree of Another Tree

 Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2

Given tree t:

   4 
  / \
 1   2

Return true, because t has the same structure and node values with a subtree of s.

Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0

Given tree t:

   4
  / \
 1   2

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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null && t==null)
            return true;
        else if(s==null || t==null)
            return false;
        else
        {
            if(s.val==t.val)
            {
                System.out.println("if: "+s.val);
                boolean check=logic(s,t);
                if(!check)
                {
                    System.out.println("if if : "+s.val);
                    return isSubtree(s.left,t) || isSubtree(s.right, t);
                }
                else
                {
                    System.out.println("if else :"+s.val);
                    return true;
                }
                    
            }
            return isSubtree(s.left,t) || isSubtree(s.right, t);
                
        }
        
    }
    public boolean logic(TreeNode p, TreeNode q)// This function returns true if p,q are same structure wise. i.e, p.val=q.val and similarly all childs have the same value
    {
        
        if(p==null && q==null)
            return true;
        else if(p==null || q==null)
            return false;
        else
        {
            if(p.val==q.val)
                return logic(p.left,q.left) && logic(p.right,q.right);
            else
            {
                return false;
            }
        }
    }
}
/*
Time Complexity - 
Space Complexity - 
*/
