/*
75. Sort Colors

https://leetcode.com/problems/sort-colors/description/

Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
*/
/*
We have four zones:  all '0', all '1', unknown, all '2'

 0  0  0  1  1  1  X  X  X  2  2  2

          i        j     k


*/

class Solution {
    public void sortColors(int[] nums) {
        int l=0,h=nums.length-1;
        for(int i=0;i<=h;)//we should continue untill i reaches h
        {
            if(nums[i]==0)//if nums[i]=0, then we swap i,l and increment i and l. This makes sure that all 0's are in the first region
            {
                swap(i,l,nums);
                i++;
                l++;
            }
            else if(nums[i]==1)//We dont have to do anything for this case
            {
                i++;
            }
            else//we try to get the 2's in the last region. So we swap i,h and decrement h. We do not increment i as we do not know what is the new value of nums[i] after swap. we have to process that accordingly 
            {
                swap(i,h,nums);
                h--;
            }
        }
        
    }
    public void swap(int i,int j,int[] nums)//swap two elements in the array
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
