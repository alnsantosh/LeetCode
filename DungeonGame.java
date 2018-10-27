/*
174. Dungeon Game

https://leetcode.com/problems/dungeon-game/description/

The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

 

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)
 

Note:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
*/
/*
Idea - If we start from top left and move towards bottom right, then the current output will depend on both past and future values. 
So we can start from bottom right and traverse to top left. At any point, we have to make sure that value does not fall to 0 as the prince will die. 
*/
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;
        int[][] dp=new int[n][m];//creating a dp array
        dp[n-1][m-1]=(dungeon[n-1][m-1]>0)?1:-(dungeon[n-1][m-1]-1);//Here if the number is positive, then the minimum health required at that location is 1. However if the number is negative, say -5, then we have to make x so that the health becomes 1 i.e, -5+x=1, x=6. Here         -(dungeon[n-1][m-1]-1),I am subtracting the negative value of dungeon with -1 and converting into positive number which gives me the minimum health required to keep the prince alive. eg: consider -5, -5-1=-6 and -(-6) = 6 is the minimum health the prince should have at dungeon[n-1][m-1].
        for(int i=n-2;i>=0;i--)//I am scanning through the rows and updating the last element in each row.Basically dp[i+1][m-1]-dungeon[i][m-1] gives me the health prince should have so that he will survive at [i][m-1] instance.If the value is less than zero, we make it 1 as we cannot make the minimum health<1
        {
            dp[i][m-1]=Math.max(dp[i+1][m-1]-dungeon[i][m-1],1);
        }
        for(int j=m-2;j>=0;j--)//Scanning through all the columns and updating lst column in each column
        {
            dp[n-1][j]=Math.max(dp[n-1][j+1]-dungeon[n-1][j],1);
        }
        for(int i=n-2;i>=0;i--)//Here I am calculating the minimum health path considering both right side path and bottom side path
        {
            for(int j=m-2;j>=0;j--)
            {
                int right=Math.max(dp[i][j+1]-dungeon[i][j],1);
                int bottom=Math.max(dp[i+1][j]-dungeon[i][j],1);
                dp[i][j]=Math.min(bottom,right);
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
        return dp[0][0];   
    }
}
/*
Time Complexity - O(n*m) - two for loops
Space Complexity - O(n*m) - Used dp array
*/
