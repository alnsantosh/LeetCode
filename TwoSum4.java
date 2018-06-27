/*
653. Two Sum IV - Input is a BST

https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True

Example 2:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False

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
class Solution {//Inorder traversal - Update the set while doing inorder traversal. At the same time check if the target-root.val is present in set, break if present, else continue the process till all the elements in the tree are parsed 
    Set<Integer> s=new HashSet<>();
    boolean found=false;
    public boolean findTarget(TreeNode root, int k) {
        logic(root,k);
        return found;
    }
    public void logic(TreeNode root, int k)
    {
        if(found || root==null)
            return;
        else
        {
            logic(root.left,k);
            if(s.size()==0)
                s.add(root.val);
            else
            {
                //System.out.print(root.val+" ");
                if(s.contains(k-root.val))
                {
                    found=true;
                    return;
                }
                else
                    s.add(root.val);
            }
            logic(root.right,k);
        }
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n)
*/
