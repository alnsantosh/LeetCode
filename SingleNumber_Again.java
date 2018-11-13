/*
136. Single Number

https://leetcode.com/problems/single-number/description/

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
*/
/*
Idea - We can use XOR operation here as we know that a^a=0
so we know that the array has all numbers repeated twice and only one number is present once
[1,2,2]. Here 1^2^2 = 1
*/
class Solution {
    public int singleNumber(int[] nums) {
        int val=0;
        for(int i=0;i<nums.length;i++)
        {
            val=val^nums[i];//doing XOR operation
        }
        return val;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
