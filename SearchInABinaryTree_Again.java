/*
700. Search in a Binary Search Tree

https://leetcode.com/problems/search-in-a-binary-search-tree/description/

Idea -- Basic recursive approach to choose the appropriate child of the current node based on the val and the value of the current node.


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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)
            return null;
        if(root.val==val)
            return root;
        else if(root.val>val)
            return searchBST(root.left,val);
        else
            return searchBST(root.right,val);
    }
}
/*
Time Complexity - O(2^h) = O(n) since it is a binary tree and h here is the height of the tree, n is the number of node in the tree. Since all the nodes in the tree are traversed, time complexity is O(n)
Space Complexity - O(h) = O(n) in case of a skewed tree. The recursive stack will have atmost n elements in the stack in case of a skewed tree
*/
