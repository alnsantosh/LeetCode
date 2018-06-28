/*
108. Convert Sorted Array to Binary Search Tree

https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5


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
    
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode res=new TreeNode(0);
        if(nums.length==0)
            return null;
        else
        {
            //System.out.println("In else");
            logic(nums,0,nums.length-1,res);
        }
        return res;
    }
    
    public void logic(int[] nums,int low,int high,TreeNode t)
    {
        if(low>high)
        {
            return;
        }
            
        int mid=low+(high-low)/2;
        //System.out.println("Low: "+low+" High:"+high+" Mid:"+mid+" nums[mid]:"+nums[mid]);
        
        //t=new TreeNode(nums[mid]);
        t.val=nums[mid];
        t.left=new TreeNode(0);
        t.right=new TreeNode(0);
        if(low>mid-1)//if new low (low)> new high (mid-1), then the node which we pass in the logic() should be null
            t.left=null;
        if(mid+1>high)//if new low (mid+1)> new high (high), then the node which we pass in the logic() should be null
            t.right=null;
        logic(nums,low,mid-1,t.left);
        logic(nums,mid+1,high,t.right);
        
        
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n)
*/
