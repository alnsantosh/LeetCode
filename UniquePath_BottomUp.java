/*
62. Unique Paths

https://leetcode.com/problems/unique-paths/description/

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28
*/

/*
Idea - Botto-up approach
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[n][m];
        return logic(m-1,n-1,dp);
    }
    public int logic(int m,int n,int[][] dp)
    {
        if(m==0 || n==0)//the first row and first column of the dp table has to be one(look top down approach code for more understanding). So, returning 1 in this case
            return 1;
        else
        {
            if(dp[n][m]>0)//if there is any value other than 0, return that value
                return dp[n][m];
            else//else compute the value which goes in that cell and return that value
            {
                dp[n][m]=logic(m-1,n,dp)+logic(m,n-1,dp);
                return dp[n][m];
            }
        }
    }
}
/*
Time Complexity - O(m*n)
Space Complexity - O(m*n)
*/
