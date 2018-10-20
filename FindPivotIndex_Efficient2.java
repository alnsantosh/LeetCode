/*
724. Find Pivot Index

https://leetcode.com/problems/find-pivot-index/description/

Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

Example 1:
Input: 
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation: 
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.
Example 2:
Input: 
nums = [1, 2, 3]
Output: -1
Explanation: 
There is no index that satisfies the conditions in the problem statement.
Note:

The length of nums will be in the range [0, 10000].
Each element nums[i] will be an integer in the range [-1000, 1000].
*/
/*
Idea - Basically I used two variable sum, leftSum
I iterate through all the elements of the array, compare the leftSum(left side sum of the pivot assuming each index to be pivot while iterating) with sum-leftSum-nums[i](this basically gives sum right side sum value assuming i as pivot index)
If these two values are equal, return the index
*/
class Solution {
    public int pivotIndex(int[] nums) {
        if(nums==null || nums.length==0)//when the array is empty
            return -1;
        // else if(nums.length==1)
        //     return 0;
        int sum=0,leftSum=0;//leftsum is to store the left side sum of the pivot
        for(int i=0;i<nums.length;i++)//calculating sum of all the elements in the array
        {
            sum+=nums[i];
        }
        for(int i=0;i<nums.length;i++)//main logic
        {
            if(leftSum==sum-leftSum-nums[i])
                return i;
            leftSum+=nums[i];
                
        }
        return -1;
    }
}
/*
Time Complexity - O(2n) = O(n) - All the elements in the array are traversed twice
Space Complexity - O(1)
*/
