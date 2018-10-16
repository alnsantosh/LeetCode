/*
198. House Robber

https://leetcode.com/problems/house-robber/description/

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
*/
/*
Idea - Kind of DP approach
yes-if the house is robbed
no-if the house is not robbed\
For every house,we compute two cases- robbed or not robebed i.e., a house can be robbed or not robbed.
We start with the first house, If the house is robbed, we add the value of nums[0](first house) to the "yes" variable
    If the first house is not robbed, then we store the max value of (previous "yes", previous "no") to "no"
Consider the second house i.e., nums[1],
    If the second house is selected, then the first house must not be selected, that means that we have to add nums[1] with prev value of "no". This would give us yes for the second house.
    If the second house is not selected, then we just have to take the max of prev no and prev yes.
*/
class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        else
        {
            int yes=0,no=0;
            for(int i=0;i<nums.length;i++)
            {
                int temp=no+nums[i];//we store in a temp value as if we update yes, we will not be able to compute no in the next step
                no=Math.max(yes,no);
                yes=temp;
                //System.out.println(yes+" "+no);
            }
            return Math.max(yes,no);
        }
           
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1) - Using two variables yes,no
*/
