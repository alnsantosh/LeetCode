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

/*
Idea - If input is [1, 2, 3, 4] then we want [2*3*4, 1*3*4, 1*2*4, 1*2*3].  Output can be constructed in two passes. The first pass, skip the first element [None, 1, 1*2, 2*3] = [1, 1, 2, 6] Each element of output is the product of all the elements before it. Then reverse this result and the nums array and apply the same method. [4, 3, 2, 1] --> [1, 4, 4*3, 4*3*2] --> [1, 4, 12, 24] 
Then combine the arrays: [1, 4, 12, 24] and [6, 2, 1, 1]
	[6, 4*2, 24*1, 1] --> [6, 8, 12, 24]. Then reverse it [24, 12, 8, 6]
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        res[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            res[i]=res[i-1]*nums[i-1];
        }
        int prod=1;//to keep the product of all the elements to the right of the nums[i], in the next for loop.
        for(int i=nums.length-2;i>=0;i--)
        {
            prod*=nums[i+1];
            res[i]*=prod;
        }
        return res;
    }
}
/*
Time Complexity - O(n) - 2 iterations
Space Complexity - O(1) if output which is returned is not considered as extra space
*/
