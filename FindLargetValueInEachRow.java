/*
515. Find Largest Value in Each Tree Row

https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

You need to find the largest value in each row of a binary tree.

Example:

Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]

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
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        List<TreeNode> l1=new ArrayList<>();
        List<TreeNode> l2=new ArrayList<>();
        l1.add(root);
        
        while(l1.size()!=0 || l2.size()!=0)
        {
            int max=Integer.MIN_VALUE;
            while(l1.size()!=0)
            {
                TreeNode temp=l1.remove(0);
                if(temp.val>max)
                    max=temp.val;
                //System.out.println(max);
                if(temp.left!=null)
                    l2.add(temp.left);
                if(temp.right!=null)
                    l2.add(temp.right);
                
            }
            res.add(max);
            if(l1.size()==0 && l2.size()==0)
            {
                break;
            }
            
            max=Integer.MIN_VALUE;
            while(l2.size()!=0)
            {
                TreeNode temp=l2.remove(0);
                if(temp.val>max)
                    max=temp.val;
                //System.out.println(max);
                if(temp.left!=null)
                    l1.add(temp.left);
                if(temp.right!=null)
                    l1.add(temp.right);
                
            }
            res.add(max);
        }
        return res;
    }
}
/*
Time Complexity O(n)
Space Complexity - O(2^h)
*/
