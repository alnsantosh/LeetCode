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
Idea - Use a hash-map to store the counts
*/
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        int k=-1,max=Integer.MIN_VALUE;
        for(int key:m.keySet())
        {
            int val=m.get(key);
            if(val>max)
            {
                max=val;
                k=key;
            }
        }
        return k;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n)
*/
