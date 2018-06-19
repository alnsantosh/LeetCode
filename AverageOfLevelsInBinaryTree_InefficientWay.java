/*

637. Average of Levels in Binary Tree
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:

Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

Note:

    The range of node's value is in the range of 32-bit signed integer.

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res=new ArrayList<>();
        List<TreeNode> l1=new ArrayList<>();
        List<TreeNode> l2=new ArrayList<>();
        if(root==null)
            return null;
        else
        {
            l1.add(root);
            double sum=0;
            int count=0;
            while(l1.size()!=0 || l2.size()!=0)
            {
                sum=0;
                count=0;
                while(l1.size()!=0)
                {
                    TreeNode temp=l1.remove(0);
                    sum+=temp.val;
                    count++;
                    if(temp.left!=null)
                    {
                        l2.add(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        l2.add(temp.right);
                    }
                }
                //System.out.println(sum+" "+count+ " "+sum/count +" "+l1.size()+" "+l2.size());
                //sum=sum/count;
                //if(sum.isNaN())
                {
                    res.add(sum/count);
                }
                
                sum=0;
                count=0;
                
                if(l1.size()==0 && l2.size()==0)
                    break;
                
                while(l2.size()!=0)
                {
                    TreeNode temp=l2.remove(0);
                    sum+=temp.val;
                    count++;
                    if(temp.left!=null)
                    {
                        l1.add(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        l1.add(temp.right);
                    }
                }
                //System.out.println(sum+" "+count+ " "+sum/count+" "+l1.size()+" "+l2.size());
                //if((sum/count).isNaN())
                {
                    res.add(sum/count);
                }
                
                
            }
            //res.remove(res.size()-1);
            return res;
 
        }
        
    }
}

/*
Time Complexity - O(n*insertion time for ArrayList)=O(n*1)=O(n)
Space Complexity - O(2^h) - where 2^h is the no. of nodes at height h
*/
