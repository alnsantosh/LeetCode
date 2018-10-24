/*
560. Subarray Sum Equals K

https://leetcode.com/problems/subarray-sum-equals-k/description/

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
*/
/*
Idea - It's brute force approach. For every subarray I am computing sum on the fly and checking if the sum==k. Based on that I am incerementing the count.
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            sum=0;
           for(int j=i;j<nums.length;j++)
           {
               sum+=nums[j];
               if(sum==k)
               {
                   //System.out.println(i+" "+j);
                   count++;
               }
                   
           }
        }
        return count;
        
    }
}
/*
Time Complexity - O(n^2)
Space Complexity - O(1)
*/
