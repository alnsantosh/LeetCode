class Solution {
    public int searchInsert(int[] nums, int target) {
        System.out.println(binarySearch(nums,target));
        return binarySearch(nums,target);
        
    }
    public int binarySearch(int[] nums, int target)
    {
        if(nums.length==0)
            return 0;
        else
        {
            int low=0;
            int high=nums.length-1;
            int mid=high-((high-low)/2);
            while(true)
            {
                if(nums[mid]==target)
                    return mid;
                else if(target>nums[mid])
               {
                    if(target>nums[high])//extra condition to regular binary search
                        return high+1;
                    
                   low=mid+1;
                   mid=high-((high-low)/2);
               }
                else
                {
                    if(target<nums[low])//extra condition to regular binary search
                        return low;
                    
                    high=mid-1;
                   mid=high-((high-low)/2);
                }
            }
        }
        
    }
}
