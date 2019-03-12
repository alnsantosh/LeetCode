/*
35. Search Insert Position

https://leetcode.com/problems/search-insert-position/description/

Idea -- Use binary search to find the desired index


*/
class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0 || target<nums[0])
            return 0;
        if(target>nums[nums.length-1])
            return nums.length;
        return binarySearch(nums,0,nums.length-1,target);
    }
    public int binarySearch(int[] nums,int low,int high,int target)
    {
        if(low==high)
        {
            if(target<=nums[low])
                return low;
            else
                return low+1;
        }
        if(low>high)
            return low;
        int mid=low+(high-low)/2;
        if(nums[mid]==target)
            return mid;
        else if(nums[mid]<target)
        {
            return binarySearch(nums,mid+1,high,target);
        }
        else
        {
            return binarySearch(nums,low,mid-1,target);
        }
    }
}
/*
Time Complexity - O(log(n)) since binary search is used
Space Complexity - O(log(n)) because of the recursive stack used
*/
