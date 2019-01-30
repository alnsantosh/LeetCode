/*
136. Single Number

https://leetcode.com/problems/single-number/description/

Idea - Use XOR operation


*/
class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            result=result^nums[i];
        }
        return result;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
