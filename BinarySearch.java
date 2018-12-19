/*
704. Binary Search

https://leetcode.com/problems/binary-search/description/

Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Note:

You may assume that all elements in nums are unique.
n will be in the range [1, 10000].
The value of each element in nums will be in the range [-9999, 9999].
*/
/*
Idea - Basic binary search
*/
class Solution {
    public int search(int[] nums, int target) {
        return logic(0,nums.length-1,nums,target);
    }
    public int logic(int low,int high,int[] nums,int target)
    {
        if(low>high)
        {
            return -1;
        }
        int mid=(low+high)/2;
        if(nums[mid]==target)
        {
            return mid;
        }
        else if(nums[mid]>target)
        {
            return logic(low,mid-1,nums,target);
        }
        else
        {
            return logic(mid+1,high,nums,target);
        }
    }
}
/*
Time Complexity - O(log(n)) n is length of nums
Space Complexity - O(1)
*/
