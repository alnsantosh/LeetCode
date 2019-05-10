/*
27. Remove Element

https://leetcode.com/problems/remove-element/submissions/

Idea: Have an index j which points to the index where the value which is not cal must be inserted. Iterate through the arrau, if the value is equal to val, skip it. Else, copy the value to nums[j] and increment j. Finally return j which is equal to the length of the new array after making all the replacements


*/
class Solution {
    public int removeElement(int[] nums, int val) {
        int j=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==val)
            {
                
            }
            else
            {
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}
/*
Time Complexity - O(n) where n is the length of the array
Space Complexity - O(1) since replacement done in place
*/
