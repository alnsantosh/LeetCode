/*
695. Max Area of Island

https://leetcode.com/problems/max-area-of-island/description/

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]

Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

Example 2:

[[0,0,0,0,0,0,0,0]]

Given the above grid, return 0.

Note: The length of each dimension in the given grid does not exceed 50. 
*/
class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                count=Math.max(count,logic(grid,i,j));
            }
        }
        return count;
    }
    public int logic(int[][] grid,int r,int c)
    {
        //System.out.println(r+" "+c);
        if(r<0 || r>grid.length-1 || c<0 || c>grid[0].length-1)
            return 0;
        else
        {
            if(grid[r][c]==1)
            {
                grid[r][c]=0;
                return 1+logic(grid,r,c+1)+logic(grid,r,c-1)+logic(grid,r+1,c)+logic(grid,r-1,c);
            }
            else
                return 0;
        }
    }
    
}
/*
Time Complexity - O(R*C+R*C) one R*C because two for loops, other R*C because using stack implementation. In any case each element is traversed at most twice. So time complexity is O(R*C) 
Space Complexity - O(R*C) worst case where all elements in arrays are 1's
*/
