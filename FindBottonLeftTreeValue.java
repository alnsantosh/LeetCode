/*
513. Find Bottom Left Tree Value

https://leetcode.com/problems/find-bottom-left-tree-value/description/

Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:

Input:

    2
   / \
  1   3

Output:
1

Example 2:

Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7

Note: You may assume the tree (i.e., the given root node) is not NULL. 
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
    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> l1=new ArrayList<>();
        List<TreeNode> l2=new ArrayList<>();
        l1.add(root);
        int left=0;
        while(l1.size()!=0 || l2.size()!=0)
        {
            boolean first=true;
            while(l1.size()!=0)
            {
                TreeNode pop=l1.remove(0);
                //System.out.println(pop.val);
                if(first)
                {
                    first=false;
                    left=pop.val;
                }
                if(pop.left!=null)
                    l2.add(pop.left);
                if(pop.right!=null)
                    l2.add(pop.right);
            }
            
            if(l1.size()==0 && l2.size()==0)
            {
                break;
            }
            first=true;
            while(l2.size()!=0)
            {
                TreeNode pop=l2.remove(0);
                //System.out.println(pop.val);
                if(first)
                {
                    first=false;
                    left=pop.val;
                }
                if(pop.left!=null)
                    l1.add(pop.left);
                if(pop.right!=null)
                    l1.add(pop.right);
            }
        }
        return left;
    }
}
/*
Time Complexity - O(n)
Space Complexity - 2^h - since at height h in binary tree, atmost 2^h nodes can be present
*/
