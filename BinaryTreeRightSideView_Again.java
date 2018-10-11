/*
199. Binary Tree Right Side View

https://leetcode.com/problems/binary-tree-right-side-view/description/

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
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
Idea-Basic level order traversal. Just add the last node value in each level to res.
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        List<TreeNode> left=new ArrayList<>();
        List<TreeNode> right=new ArrayList<>();
        left.add(root);
        while(!(left.size()==0 && right.size()==0))
        {
            TreeNode t=null;
            while(left.size()!=0)
            {
                t=left.remove(0);
                if(t.left!=null)
                    right.add(t.left);
                if(t.right!=null)
                    right.add(t.right);
            }
            res.add(t.val);
            if(left.size()==0 && right.size()==0)
                break;
            while(right.size()!=0)
            {
                t=right.remove(0);
                if(t.left!=null)
                    left.add(t.left);
                if(t.right!=null)
                    left.add(t.right);
            }
            res.add(t.val);
        }
        return res;
        
    }
}
/*
Time Complexity - O(n) - Since all the nodes are traversed
Space Complexity - O(2^h) where h is the height of the tree
*/
