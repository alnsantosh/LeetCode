/*
897. Increasing Order Search Tree

https://leetcode.com/problems/increasing-order-search-tree/description/

Idea - Store all the nodes in the tree into an ArrayList and make appropriate linkings

Inspired from
https://leetcode.com/problems/increasing-order-search-tree/solution/
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
    public TreeNode increasingBST(TreeNode root) {
        if(root==null)
            return root;
        List<TreeNode> tree=new ArrayList<>();
        inOrder(root,tree);//Loading all the nodes in the tree into tree Arraylist using InOrder traversal
        TreeNode t=new TreeNode(-1);
        TreeNode temp=t;
        for(int i=0;i<tree.size();i++)//logic for linking nodes in desired format
        {
            //System.out.print(tree.get(i).val+" ");
            TreeNode node=tree.get(i);
            node.left=null;
            t.right=node;
            t=node;
            
        }
        return temp.right;
    }
    public void inOrder(TreeNode root,List<TreeNode> tree)
    {
        if(root==null)
            return;
        inOrder(root.left,tree);
        tree.add(root);
        inOrder(root.right,tree);
    }
}
/*
Time Complexity - O(n) since traversed through all the nodes of the tree
Space Complexity - O(n) since used ArrayList to store all the TreeNodes in it
*/
/*
*/
