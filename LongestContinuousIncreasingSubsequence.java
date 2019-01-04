/*
674. Longest Continuous Increasing Subsequence

https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/

Idea - Two pointers approach.
Update the length variable whenever nums[i-1]<nums[i] accordingly. When this condition is failed, update j variable accordingly.
*/
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int j=0;
        int length=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>nums[i-1])
            {
                if(length<i-j+1)
                {
                    length=i-j+1;
                }
            }
            else
            {
                j=i;
            }
        }
        return length;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
