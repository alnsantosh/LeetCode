/*
169. Majority Element

https://leetcode.com/problems/majority-element/description/

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
*/
/*
Idea - Sort the array
Since there is always an majourity element and majourity element is repeated atleast array.length/2. It means the array.length/2 will always contain the majourity element.
*/
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
        
    }
}
/*
Time Complexity - O(nlog(n))  - Because we are sorting the array
Space Complexity - O(1)
*/
