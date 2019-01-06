/*
189. Rotate Array

https://leetcode.com/problems/rotate-array/description/

Idea - Write a method which rotates the array by 1 step. Run this method for k times


*/
class Solution {
    public void rotate(int[] nums, int k) {
        for(int i=0;i<k;i++)
            rotateRight(nums);
    }
    public void rotateRight(int[] nums)
    {
        int t=nums[nums.length-1];
        int temp=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int temp2=nums[i];
            nums[i]=temp;
            temp=temp2;
        }
        nums[0]=t;
    }
}
/*
Time Complexity - O(n*k) where n=length of nums array, k is given as parameter in rotate method
Space Complexity - O(1)
*/
