/*
107. Binary Tree Level Order Traversal II

https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
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
Idea-Normal level order traversal
*/
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        List<TreeNode> left=new ArrayList<>();
        List<TreeNode> right=new ArrayList<>();
        left.add(root);
        while(!(left.isEmpty() && right.isEmpty()))
        {
            List<Integer> temp=new ArrayList<>();
            while(!left.isEmpty())
            {
                TreeNode t=left.remove(0);
                temp.add(t.val);
                if(t.left!=null)
                    right.add(t.left);
                if(t.right!=null)
                    right.add(t.right);
            }
            res.add(0,temp);
            temp=new ArrayList<>();
            if(left.isEmpty() && right.isEmpty())
                break;
            while(!right.isEmpty())
            {
                TreeNode t=right.remove(0);
                temp.add(t.val);
                if(t.left!=null)
                    left.add(t.left);
                if(t.right!=null)
                    left.add(t.right);
            }
            res.add(0,temp);
        }
        return res;
            
        
    }
}
/*
Time Complexity - O(n) - Since all the elements are traversed in the tree
Space Complexity - O(2^h) where h is height of the tree
*/
