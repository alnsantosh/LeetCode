/*
746. Min Cost Climbing Stairs

https://leetcode.com/problems/min-cost-climbing-stairs/description/

On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
Note:
cost will have a length in the range [2, 1000].
Every cost[i] will be an integer in the range [0, 999].
*/
/*
Idea - Consider a dp array of length=length of cost
Cost incurred at ith step= Min(cost incurred till (i-1)th step, cist incurred till (i-2)th step)+cost of ith step
Note that we do nnot return the dp[dp.length] as it might not be the least cost which we are expecting. We also need to look at dp[dp.length-2] and return the minimum value out of those two values.
*/
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost==null || cost.length==0)//base case
            return 0;
        if(cost.length==1)//writing this case since filling the value dp[1] without any check
            return cost[0];
        int[] dp=new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<cost.length;i++)
        {
            dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
        
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n)
*/
