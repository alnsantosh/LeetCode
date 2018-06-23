/*
654. Maximum Binary Tree

https://leetcode.com/problems/maximum-binary-tree/description/

 Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

    The root is the maximum number in the array.
    The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.

Construct the maximum tree by the given array and output the root node of this tree.

Example 1:

Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1

Note:

    The size of the given array will be in the range [1,1000].

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return logic(nums,0,nums.length-1);
        
    }
    public TreeNode logic(int[] nums, int low,int high)//create the tree by calculating max value recursively
    {
        if(low>high)//edge case - when index reaches either low or high, then the updated value of low and high in next recursion will give out of bounds error
            return null;
        int index=max(nums,low,high);
        //System.out.println(index);
        TreeNode t=new TreeNode(nums[index]);

        t.left=logic(nums,low,index-1);

        t.right=logic(nums,index+1,high);
        return t;
    }
    public int max(int[] nums,int low,int high)//calculating max value withing [low,high] in nums array
    {
        int max=Integer.MIN_VALUE;
        int index=-1;
        for(int i=low;i<=high;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
                index=i;
            }
                
        }
        return index;
    }
}
/*
Time Comlpexity - O(n^2) n for calculating max, another n in logic function
Space Complexity - O(n)
*/
