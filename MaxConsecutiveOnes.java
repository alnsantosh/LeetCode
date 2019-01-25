/*
485. Max Consecutive Ones

https://leetcode.com/problems/max-consecutive-ones/description/

Idea -- Iterate through the given array and count the number of consecutive 1's while iterating.
Use a variable count to store the mac consective ones value. Keep on updating this variable based on the values obtained in the array while iterating.


*/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;//stores the max consecutive ones count
        int i=0;
        while(i<nums.length)
        {
            int temp=0;//temporary count
            if(nums[i]==1)
            {
                //temp++;
                while(i<nums.length && nums[i++]==1)//increment the temporary count till we get 0
                    temp++;
                if(temp>count)//update count
                    count=temp;
            }
            else
            {
                i++;
            }
            
        }
        return count;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
