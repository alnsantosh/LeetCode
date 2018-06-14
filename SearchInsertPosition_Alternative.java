/*
35. Search Insert Position

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2

Example 2:

Input: [1,3,5,6], 2
Output: 1

Example 3:

Input: [1,3,5,6], 7
Output: 4

Example 4:

Input: [1,3,5,6], 0
Output: 0


*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        System.out.println(binarySearch(nums,target));
        return binarySearch(nums,target);
        
    }
    public int binarySearch(int[] nums, int target)
    {
        if(nums.length==0 || target<nums[0])
            return 0;
        else if(target>nums[nums.length-1])
            return nums.length;
        else
        {
            int low=0;
            int high=nums.length-1;
            int mid=high-(high-low)/2;
            while(low<=high)
            {
                mid=high-(high-low)/2;
                if(nums[mid]==target)
                {              
                    return mid;
                }
                else if(nums[mid]>target)
                {
                    // if(nums[mid-1]<target)   //If this is uncommented, then "return low" will never be called, still the solution will be accepted, just anothet way of doing it
                    //     return mid;
                    high=mid-1;
                }
                else if(nums[mid]<target) //If this is uncommented, then "return low" will never be called, still the solution will be accepted, just anothet way of doing it
                {
                    // if(nums[mid+1]>target)
                    //     return mid+1;
                    low=mid+1;
                }
            }
            return low; //When we put condition low<=high, we can simply return low after the normal BS, if element in array the index is returned(Regular binary search), If element is not present, then low will always point to the index whose value is greater than target, in other words low holds the index which needs to be returned.
        }
        
    }
}

/*
Time Complexity - O(log(n))
*/
