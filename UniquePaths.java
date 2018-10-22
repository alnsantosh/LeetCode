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
Top-Down approach - Fill the first row and column by 1's because any cell in 1st row and 1st column can be reached in only 1 way
Now for the rest of the cells, number of ways to reach that cell is the sum of number of ways of reaching left cell and above cell.
Finally, th bottom right element in the dp array has the desired answer.
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++)//Initializing 1st column to 1
        {
            dp[i][0]=1;
        }
        for(int j=0;j<m;j++)//Initialising 1st row to 1
        {
            dp[0][j]=1;
        }
        for(int i=1;i<n;i++)//logic
        {
            for(int j=1;j<m;j++)
            {
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        // for(int i=0;i<n;i++)//printing elements of the array
        // {
        //     for(int j=0;j<m;j++)
        //     {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return dp[n-1][m-1];
    }
}
/*
Time Complexity - O(m*n) - Two for loops used
Space Complexity - O(m*n) - using dp array
*/
