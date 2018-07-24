/*
222. Count Complete Tree Nodes

https://leetcode.com/problems/count-complete-tree-nodes/description/

Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6

*/
/*
Idea - The height of a tree can be found by just going left. Let a single node tree have height 0. Find the height h of the whole tree. If the whole tree is empty, i.e., has height -1, there are 0 nodes.

Otherwise check whether the height of the right subtree is just one less than that of the whole tree, meaning left and right subtree have the same height.

    If yes, then the last node on the last tree row is in the right subtree and the left subtree is a full tree of height h-1. So we take the 2^h-1 nodes of the left subtree plus the 1 root node plus recursively the number of nodes in the right subtree.
    If no, then the last node on the last tree row is in the left subtree and the right subtree is a full tree of height h-2. So we take the 2^(h-1)-1 nodes of the right subtree plus the 1 root node plus recursively the number of nodes in the left subtree.

Since I halve the tree in every recursive step, I have O(log(n)) steps. Finding a height costs O(log(n)). So overall O(log(n)^2).
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
    public int countNodes(TreeNode root) {
        return logic(root);
        
    }
    public int logic(TreeNode root)
    {
        if(root==null)
            return 0;
        int sum=0;
        int h=height(root);
        if(h-1==height(root.right))
        {
            //System.out.println(h+" "+(int)Math.pow(2,h)+" "+logic(root.right));
            sum+=(int)Math.pow(2,h)+logic(root.right);
        }
        else
        {
            //System.out.println(h+" "+(int)Math.pow(2,h-1)+" "+logic(root.left));
            sum+=(int)Math.pow(2,h-1)+logic(root.left);
        }
        return sum;
    }
    public int height(TreeNode root)
    {
        int h=-1;
        while(root!=null)
        {
            root=root.left;
            h++;
        }
        return h;
    }
}
/*
Time Complexity - O(log(n)^2) - O(log(n)*log(n)) - log(n) for finding the height of the tree. Another log(n) for for going to either left or right subtree based on the condition
Space Complexity - O(log(n)) - Height of complete tree will be O(log(n)) for the complete tree. So the recursive stack will have atmost log(n) elements.
*/
