/*
167. Two Sum II - Input array is sorted

https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

Idea -- Two pointer approach. i points at the beginning of the array and j points at the end of the array
check if sum of elements at i and j equals target.Make the updates on i and j accordingly


*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null || numbers.length==0)
            return null;
        int i=0,j=numbers.length-1;
        while(i<j)
        {
            if(numbers[i]+numbers[j]==target)
            {
                //return new int[]{i+1,j+1};
                break;
            }
            else if(numbers[i]+numbers[j]<target)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return new int[]{i+1,j+1};
        
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
