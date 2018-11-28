/*
152. Maximum Product Subarray

https://leetcode.com/problems/maximum-product-subarray/description/

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/
/*
Idea - Use variables min,max to store the current minimum and maximum value
if nums[i] is -ve, then we reverse min and max. 
*/
class Solution {
    public int maxProduct(int[] nums) {
        int res=nums[0];
        int min=nums[0],max=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                int temp=min;
                min=max;
                max=temp;
            }
            //System.out.println(min+" "+max+" "+nums[i]+" "+res);
            min=Math.min(nums[i],min*nums[i]);
            max=Math.max(nums[i],max*nums[i]);
            res=Math.max(max,res);
            //System.out.println(min+" "+max+" "+nums[i]+" "+res);
            //System.out.println("-----");
        }
        return res;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
