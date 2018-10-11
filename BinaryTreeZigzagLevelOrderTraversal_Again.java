/*
103. Binary Tree Zigzag Level Order Traversal
DescriptionHintsSubmissionsDiscussSolution
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
/*
Idea - Basic level order traversal variant
Focus on the order in which the element are inserted into left and right lists to get the desired output
*/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> l=new ArrayList<>();
        if(root==null)
            return l;
        List<TreeNode> left=new ArrayList<>();
        List<TreeNode> right=new ArrayList<>();
        left.add(root);
        while(left.size()!=0 || right.size()!=0)
        {
            
            //l.add(new ArrayList<>(left));
            List<Integer> temp=new ArrayList<>();
            while(left.size()!=0)
            {
                TreeNode t=left.remove(0);
                temp.add(t.val);
                if(t.left!=null)
                    right.add(0,t.left);
                if(t.right!=null)
                    right.add(0,t.right);
            }
            l.add(temp);
            temp=new ArrayList<>();
            if(left.size()==0 && right.size()==0)
                break;
            //l.add(new ArrayList<>(right));
            while(right.size()!=0)
            {
                TreeNode t=right.remove(0);
                temp.add(t.val);
                if(t.right!=null)
                    left.add(0,t.right);
                if(t.left!=null)
                    left.add(0,t.left);
            }
            l.add(temp);
        }
        return l;
    }
}
/*
Time Complexity - O(n) - Since we go through all the elements in the tree
Space Complexity - O(2^h) where h is the height of the tree
*/
