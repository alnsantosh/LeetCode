/*
213. House Robber II

https://leetcode.com/problems/house-robber-ii/description/

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
*/
/*
Idea - 
yes - Represents house is robbed
no - Represents house is not robbed

We need to implement logic used in House Robber problem. Here we take two case
1)Consider all the houses except the last one
2)Consider all houses except the first one
Take the max value from the above two obtained values
The edge case here would be considering nums.length==1 case. Here if we dont write extra code for this it will always return 0
*/
class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)//base case
            return 0;
        else if(nums.length==1)
            return nums[0];
        int yes=0,no=0;
        for(int i=0;i<nums.length-1;i++)//Considering 0 to nums.length-2
        {
            int temp=nums[i]+no;
            no=Math.max(yes,no);
            yes=temp;
        }
        int res1=Math.max(yes,no);
        
        yes=0;
        no=0;
        for(int i=1;i<nums.length;i++)//Considering 1 to nums.length-1
        {
            int temp=nums[i]+no;
            no=Math.max(yes,no);
            yes=temp;
        }
        int res2=Math.max(yes,no);
        
        return Math.max(res1,res2);
        
    }
}
/*
Time Complexity - O(n+n) = O(n) Since all the elements in nums are travsersed twice
Space Complexity - O(1) - Just used two variables yes,no
*/
