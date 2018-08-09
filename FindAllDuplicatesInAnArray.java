/*
442. Find All Duplicates in an Array

https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

*/
/*
Idea - We traverse all the elements in the array, for each element, treat that as index and go to that corresponding index. Reverse the sign there. Repeat this process.

Why this works - The element which is repeated twice will fetch the same location twice. So if an element is negative, then it means that location is already been fetched. So this index is repeated. Store this index in the res. 

Extension - We can extend this question to any number of repeated elements. To acheive this, only negate once, if the element is already -ve, do not make that +ve. This way, we can find if there are more than two repetitions of the same element.
*/
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new ArrayList<>();
         for(int i=0;i<nums.length;i++)
         {
             int temp=Math.abs(nums[i]);
             if(nums[temp-1]<0)
             {
                 res.add(temp);
             }
             nums[temp-1]=-nums[temp-1];
         }
        return res;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
