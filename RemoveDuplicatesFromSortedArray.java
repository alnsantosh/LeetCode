/*
26. Remove Duplicates from Sorted Array

https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Idea: Traverse through the given array and have a index pointing to the next location where the value needs to be replaces. While traversing, if the current and previous element mismatches, update that with the nums[j] and increment j
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int j=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1])
            {
                
            }
            else
            {
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}

/*
Time Complexity - O(n) where n is the length of the array
Space Complexity - O(1) since no extra memory is used
*/
