/*
73. Set Matrix Zeroes

https://leetcode.com/problems/set-matrix-zeroes/description/

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]

Follow up:

    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?


*/

/*
Idea - Wherever u find 0, replace that row and column values with Integer.MAX_VALUE expect for the elements which are 0 in that row or column.
Later in another iteration, replace all the Integer.MAX_VALUE with 0.
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    for(int k=0;k<matrix.length;k++)
                    {
                        if(matrix[k][j]!=0)
                            matrix[k][j]=Integer.MAX_VALUE-5;
                    }
                    for(int k=0;k<matrix[i].length;k++)
                    {
                        if(matrix[i][k]!=0)
                            matrix[i][k]=Integer.MAX_VALUE-5;
                    }
                }
            }
        }
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]==Integer.MAX_VALUE-5)
                {
                    matrix[i][j]=0;
                }
            }
        }
        
    }
}
/*
Time Complexity - O(n^2)
Space Complexity - O(1)
*/
