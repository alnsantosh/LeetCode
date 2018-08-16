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
 Idea - BFS approach
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        List<TreeNode> l1=new ArrayList<>();
        List<TreeNode> l2=new ArrayList<>();
        if(root==null)
            return res;
        l1.add(root);
        TreeNode tmp=null;
        boolean b1=false,b2=false;
        while(l1.size()!=0 || l2.size()!=0)
        {
            while(l1.size()!=0)
            {
                b1=true;
                tmp=l1.remove(0);
                //System.out.println(tmp.val);
                if(tmp.left!=null)
                {
                    l2.add(tmp.left);
                }
                if(tmp.right!=null)
                {
                    l2.add(tmp.right);
                }
            }
            res.add(tmp.val);// we store the last element of the l1
            if(l1.size()==0 && l2.size()==0)
                break;
            tmp=null;
            while(l2.size()!=0)
            {
                b2=true;
                tmp=l2.remove(0);
                //System.out.println(tmp.val);
                if(tmp.left!=null)
                {
                    l1.add(tmp.left);
                }
                if(tmp.right!=null)
                {
                    l1.add(tmp.right);
                }
            }
            res.add(tmp.val);// we store the last element of l2
        }
        return res;
    }
}
/*
Time Complexity - O(n) - Since we are iterating throught all the nodes of the tree
Space Complexity - O(2^h) where h is heigth of the tree. At any point the list will store the elements in a level. At h, the no of nodes will be maximum
*/
