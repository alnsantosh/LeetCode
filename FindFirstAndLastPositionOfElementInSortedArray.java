/*
34. Find First and Last Position of Element in Sorted Array

https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{binarySearchLeft(nums,0,nums.length-1,target),binarySearchRight(nums,0,nums.length-1,target)};
    }
    
    public int binarySearchLeft(int[] nums,int low,int high,int target)//to find the leftmost index of the target
    {
        if(low>high)
            return -1;
        int mid=low+(high-low)/2;
        //System.out.println(low+" "+high+" "+mid+" "+target+" "+nums[mid]);
        if(nums[mid]==target)
        {
            if(mid==0)//If mid is zero, nothing on left, so we retyrn mid
                return mid;
            if(mid>0 && nums[mid-1]<target)//we check mid>0 condition just to make sure we do not get ArrayOutOfBoundsException
            {
                return mid;
            }
            return binarySearchLeft(nums,low,mid-1,target);//We go in left direction even if we find that target at mid as nums[mid-1] also has the target
               
        }
        else if(nums[mid]<target)
        {
            return binarySearchLeft(nums,mid+1,high,target);
        }
        else
        {
            return binarySearchLeft(nums,low,mid-1,target);
        }
    }
    
    public int binarySearchRight(int[] nums,int low,int high,int target)//to find the rightmost index of the target
    {
        if(low>high)
            return -1;
        int mid=low+(high-low)/2;
        //System.out.println(low+" "+high+" "+mid+" "+target+" "+nums[mid]);
        if(nums[mid]==target)
        {
            if(mid==nums.length-1)//If mid is nums.length-1, nothing on right, so we return mid
                return mid;
            if(mid<nums.length-1 && nums[mid+1]>target)//we check mid<nums.length-1 condition just to make sure we do not get ArrayOutOfBoundsException
            {
                return mid;
            }
            return binarySearchRight(nums,mid+1,high,target);
               
        }
        else if(nums[mid]<target)
        {
            return binarySearchRight(nums,mid+1,high,target);
        }
        else
        {
            return binarySearchRight(nums,low,mid-1,target);
        }
    }
}
/*
Time Complexity - O(log(n))
Space Complexity - O(1) if output array is not considered as extra space
*/
