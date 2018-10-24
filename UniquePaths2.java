/*
63. Unique Paths II

https://leetcode.com/problems/unique-paths-ii/description/

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?



An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
*/
/*
Idea - Top-down approach
Detailed explaination given at the following link
https://leetcode.com/problems/unique-paths-ii/solution/
*/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid ==null || obstacleGrid[0][0]==1)
            return 0;
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[][] dp=new int[n][m];
        boolean row=true,col=true;
        for(int i=0;i<n;i++)//filling up the first row
        {
            if(obstacleGrid[i][0]==1)
            {
                dp[i][0]=0;
                row=false;
            }
            else
            {
                if(row)
                    dp[i][0]=1;   
                else
                    dp[i][0]=0;   
            }
        }
        for(int j=0;j<m;j++)//filling up the first column
        {
            if(obstacleGrid[0][j]==1)
            {
                dp[0][j]=0;
                col=false;
            }
            else
            {
                if(col)
                    dp[0][j]=1;
                else
                    dp[0][j]=0;
            }
        }
        for(int i=1;i<n;i++)//logic
        {
            for(int j=1;j<m;j++)
            {
                if(obstacleGrid[i][j]==1)
                    dp[i][j]=0;
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        // for(int i=0;i<n;i++)
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
Time Complexity - O(n*m)
Space Complexity - O(n*m)
*/
