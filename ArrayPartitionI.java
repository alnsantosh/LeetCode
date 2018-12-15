/*
561. Array Partition I

https://leetcode.com/problems/array-partition-i/description/

Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
*/
/*
Idea - We have to find a pair such that we maximize the sum of min value in each pair
In other words, when we sort the array we form the desires pairs
We just have to sum the alternate elements in the array such that the sum i.e., sum all the elements whose inde=ices are divisible by 2
*/
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                sum+=nums[i];
            }
        }
        return sum;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
