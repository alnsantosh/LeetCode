/*
103. Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        List<TreeNode> l1=new ArrayList<>();//Using two lists to solve the problem
        List<TreeNode> l2=new ArrayList<>();
        l1.add(root);
        while(l1.size()!=0 || l2.size()!=0)
        {
            List<Integer> temp=new ArrayList<>();
            while(l1.size()!=0)
            {
                TreeNode top=l1.remove(0);
                temp.add(top.val);
                if(top.left!=null)
                    l2.add(top.left);
                if(top.right!=null)
                    l2.add(top.right);
            }
            res.add(temp);
            temp=new ArrayList<>();
            if(l1.size()==0 && l2.size()==0) //This condition to ensure that if both the lists become empty,we are breaking the loop
                break;
            while(l2.size()!=0)
            {
                TreeNode top=l2.remove(0);
                temp.add(0,top.val);//Since we need to add in reverse order, insertion of value is always done at the first position
                if(top.left!=null)
                    l1.add(top.left);
                if(top.right!=null)
                    l1.add(top.right);
            }
            res.add(temp);
        }
        return res;
    }
}

/*
Time Complexity - O(n) - since we are traversing all the elements of the tree
Space Complexity - O(2^h) - since 2^h are the number of nodes that are present at height h. Since it is a variant of level order traversal, the complexuty will be the max number of nodes at any height. If h is height of the tree, then the complexity of the above code will be O(2^h)
*/
