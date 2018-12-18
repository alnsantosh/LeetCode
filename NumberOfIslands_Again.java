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
/*
Idea - Iterate through all the elements in the grid array and call the logic function when 1 is encountered and not yet visited.
logic() basically performs dfs and traverses the connected component
Increment count everytind the logic function is called. It tells the number of islands in the given matrix
*/
class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]=='1' && !vis[i][j])
                {
                    logic(i,j,grid,vis);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void logic(int i,int j,char[][] grid,boolean[][] vis)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || vis[i][j] || grid[i][j]!='1')
        {
            return;
        }
        vis[i][j]=true;
        logic(i,j+1,grid,vis);
        logic(i,j-1,grid,vis);
        logic(i+1,j,grid,vis);
        logic(i-1,j,grid,vis);
    }
}
/*
Time Complexity - O(m*n) m=grid.length,n=grid[0].length
Space Complexity - O(m*n) Used vis[][] array
*/
