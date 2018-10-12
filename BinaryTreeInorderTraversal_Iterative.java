/*
94. Binary Tree Inorder Traversal

https://leetcode.com/problems/binary-tree-inorder-traversal/description/

Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
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
Iterative Solution - 
Consider an arraylist for final result
stack for storing the TreeNode 
while(root is not null || stack is not empty)
{
    while(root is not null)
    {
        push the root to stack.
        Traverse along the left edge
    }//breaks when there is no further left edge
    pop the topmost elemnt from the stack
    add the popped value to final result
    Now see if there is any right edge to the root node.Continue the above process
    
}
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s=new Stack<>();
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        while(root!=null || s.size()!=0)
        {
            while(root!=null)
            {
                //System.out.println(root.val);
                s.push(root);
                root=root.left;
            }
            TreeNode top=s.pop();
            res.add(top.val);
            root=top.right;
        }
        return res;
    }
}
/*
Time Complexity - O(n) - Since all the elements are traversed
Space Complexity - O(h) where h=n(worst case- for a skewed tree). Atmost n elements will be stored in the stack. So O(n)
*/
