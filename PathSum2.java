/*
113. Path Sum II

https://leetcode.com/problems/path-sum-ii/description/

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
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
Idea - DFS approach
*/
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> l=new ArrayList<>();
        logic(root,sum,l);
        return res;
        
    }
    
    public void logic(TreeNode root,int sum,List<Integer> l)
    {
        if(root==null)//base case
            return;
        l.add(root.val);
        if(root.left==null && root.right==null)//leaf node
        {
            if(sum-root.val==0)
            {
                res.add(new ArrayList<>(l));
            }
        }
        logic(root.left,sum-root.val,l);
        logic(root.right,sum-root.val,l);
        l.remove(l.lastIndexOf((root.val)));//we have to remove the element at the end or else the output will have all the traversed nodes instead of the nodes which actually make up the given sum
        /*
        l.remove(new Integer(root.val)); - Here we use "new Integer()" because the indexes and values are both of types integer. If I directly write l.remove(root.val)- Then it looks for the index instead of value. So, I used "new Integer()" there.
        However above approach is wrong because we have to remove the last occurence of the value. The above logic removes the first occurence of the value.
        
        l.remove(l.lastIndexOf(new Integer(root.val))); - It removes last index of the value which is our desired functionality.
        Here since we are using l.lastIndexOf() method, it does not matter if I use "new Integer()" as it by default takes value only.
        Hence,  l.remove(l.lastIndexOf(root.val)); - works fine
        */
    }
}
/*
Time Complexity  - O(n) - Since all the elements in the tree are traversed
Space Complexity - O(n) - In case of skewed matrix
*/
