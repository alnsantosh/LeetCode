/*
448. Find All Numbers Disappeared in an Array

https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

*/
/*
Idea - Iterate through each element in the array, if nums[that particular index] is greater than 0, then negate the number.
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++)
        {
            int j=Math.abs(nums[i])-1;
            if(nums[j]>0)
                nums[j]=-nums[j];
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
                res.add(i+1);
        }
        
        return res;
            
    }
}

/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
