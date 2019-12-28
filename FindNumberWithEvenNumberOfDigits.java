/*
1295. Find Numbers with Even Number of Digits
Idea: For each integer in nums, count the number of digits and increment the count if the number of digits is even.
*/
class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
         for(int i=0;i<nums.length;i++)
         {
             if(hasEvenDigits(nums[i]))
             {
                 count++;
             }
         }
        return count;
    }
    public boolean hasEvenDigits(int num)
    {
        int len=0;
        while(num>0)
        {
            num=num/10;
            // len+=1;//dx
            len++;
        }
        return len%2==0;
    }
}
/*
Time Complexity: O(n*m) where n=length of nums array, m=number of digits in each integer of nums array
Space Complexity: O(1)
*/
