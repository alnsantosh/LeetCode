/*
404. Sum of Left Leaves

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

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
    public int sumOfLeftLeaves(TreeNode root) {
        return convert(root,false); //the boolean variable is to differentiate between the left subtree and the right subtree
    }
    public int convert(TreeNode root,boolean type)
    {
        if(root==null)
            return 0;
        else if(root.left==null && root.right==null && type)//if the leaf node is left child, then we return val else return 0
            return root.val;
        else
        {
            return convert(root.left,true)+convert(root.right,false);//
        }
    }
}

/*
Time Complexity - O(n) - dfs approach
Space Complexity - O(h) 
*/


//-----------------------------Other ways of doing the above problem
public int sumOfLeftLeaves(TreeNode root) {
    if(root == null) return 0;
    int ans = 0;
    if(root.left != null) {
        if(root.left.left == null && root.left.right == null) ans += root.left.val;
        else ans += sumOfLeftLeaves(root.left);
    }
    ans += sumOfLeftLeaves(root.right);
    
    return ans;
}

/*Nice way to use a boolean variable to determine if in left subtree or right subtree. Instead of this approach, we can also write another function and include a boolean variable which does the same thing.*/

class Solution {
    boolean left ;
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if(root == null)
            return 0;
        if(root.left == null && root.right == null && left)
            return root.val;
        left = true;
        sum += sumOfLeftLeaves(root.left);
        left = false;
        sum+= sumOfLeftLeaves(root.right);
        return sum;
        
    }
}

