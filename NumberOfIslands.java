/*
200. Number of Islands

https://leetcode.com/problems/number-of-islands/description/

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3


*/
class Solution {
    boolean visited[][];//global array to track the visited grid location
    public int numIslands(char[][] grid) {
                
        if(grid.length==0)
            return 0;
        
        int count=0;
        visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]=='1' && !visited[i][j])
                {
                    logic(grid,i,j);
                    count+=1;//we increment the count whenevr this if condition is satisfied. At the end, this count is equal to the number of connected components i.e., no. of islands in this context
                }
            }
        }
        return count;
    }
    
    public void logic(char[][] grid,int i,int j)//dfs approach. Spreading out in all the four directions
    {
        //System.out.println(i+" "+j);
        
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]=='0' || visited[i][j])
        {
            return;
        }
        else
        {
            
            visited[i][j]=true;
            logic(grid,i+1,j);
            logic(grid,i-1,j);
            logic(grid,i,j+1);
            logic(grid,i,j-1);
            
        }
    }
}
/*
Time Complexity - O(n^2)
Space Complexity - O(n) since used visited array. The space complexity can be made O(1) by making grid[i][j]=0 instead of making visited[i][j]=true; i.e., not using visited array.
*/
