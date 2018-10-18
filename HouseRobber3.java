/*
337. House Robber III

https://leetcode.com/problems/house-robber-iii/description/

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
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
Idea - Kind of brute force.

Inspired from:
https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
*/
class Solution {
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        int temp=0;
        if(root.left!=null)
            temp+=rob(root.left.left)+rob(root.left.right);
        if(root.right!=null)
            temp+=rob(root.right.left)+rob(root.right.right);
        return Math.max(root.val+temp,rob(root.left)+rob(root.right));
            
        
    }
}

/*
Time Complexity - O()
Space Complexity - O(n) - In case of skewed matrix
*/
