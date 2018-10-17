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
Idea - Take an array dp of n+1 length.
dp[0]=0//Initialize first value with 0
dp[1]=nums[0]//since we need not compute anything when we have one house. We can directly return the value of the house if only one house is present. So we directly store nums[0]
From here on,
i is the index of th house we are currently processing
j is the index in the dp which we have to fill with appropriate value
1)If the house is not robbed, then we take the prev value in dp i.e, dp[j-1] and store that i dp[j]
2)If the house id robbed, then we take the dp[j-2]+nums[i] (nums[i] is the value of the house, we cannot choose dp[j-1] as consecutive houses cannot be robbed)
*/
class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int dp[]=new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int j=i+1;
            //System.out.println(i+" "+dp[j-1]+" "+(nums[i]+dp[j-2]));
            dp[j]=Math.max(dp[j-1],nums[i]+dp[j-2]);
        }
        return dp[dp.length-1];
        
        
    }
}
/*
Time Complexity - O(n) - Traversing all the elements in the array
Space Complexity - O(n+1)=O(n) - Using dp array of length n+1
*/
