/*
280. Wiggle Sort

Given an unsorted array nums, reorder it in-place such that

nums[0] <= nums[1] >= nums[2] <= nums[3]....

Example

Given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
Notice

Please complete the problem in-place.

*/
/*
Idea - if(nums[0]>nums[1])...swap those. Similarly. if(nums[1]<nums[2]) swap them. and so on..
Basically I am trying to enforce the given condition
*/
public class Solution {
    /*
     * @param nums: A list of integers
     * @return: nothing
     */
    public void wiggleSort(int[] nums) {
        // write your code here
        for(int i=0;i<nums.length-1;i++)
        {
            if(i%2==0)
            {
                if(nums[i]>nums[i+1])
                {
                    swap(nums,i,i+1);
                }
            }
            else
            {
                if(nums[i]<nums[i+1])
                {
                    swap(nums,i,i+1);
                }
            }
        }
    }
    
    public void swap(int[] nums, int i, int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}

/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
