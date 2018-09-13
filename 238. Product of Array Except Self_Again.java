/*
238. Product of Array Except Self

https://leetcode.com/problems/product-of-array-except-self/description/

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        int prod=1;
        res[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            res[i]=prod*nums[i-1];
            prod=prod*nums[i-1];
        }
        prod=1;
        for(int i=nums.length-2;i>=0;i--)
        {
            res[i]=res[i]*prod*nums[i+1];
            prod=prod*nums[i+1];
        }
        return res;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
