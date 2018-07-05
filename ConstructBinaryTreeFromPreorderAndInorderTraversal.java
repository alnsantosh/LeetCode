/*
105. Construct Binary Tree from Preorder and Inorder Traversal

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return logic(0,0,inorder.length-1,preorder,inorder);
    }
    
    public TreeNode logic(int pre,int instart,int inend,int[] preorder,int[] inorder)
    {
        if(pre>preorder.length-1 || instart>inend)
            return null;
        TreeNode root=new TreeNode(preorder[pre]);
        int index=-1;
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==preorder[pre])
            {
                index=i;
                break;
            }
        }
        root.left=logic(pre+1,instart,index-1,preorder,inorder);
        root.right=logic(pre+index-instart+1,index+1,inend,preorder,inorder);
        return root;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n)
*/
