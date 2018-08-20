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
class Solution {
    public void setZeroes(int[][] matrix) {
        
        if(matrix==null || matrix.length==0 || matrix[0].length==0)//base case
            return;
        
        boolean row=false,column=false;//row is made true if the 0th row has atleast one 0 in it. Similarly, column is made true if one of the value in the 0th column is 0.
        for(int i=0;i<matrix.length;i++)//Logic to make row=true
        {
            if(matrix[i][0]==0)
            {
                row=true;
            }
        }
        for(int j=0;j<matrix[0].length;j++)//Logic to make column=true
        {
            if(matrix[0][j]==0)
            {
                column=true;
            }
        }
        
                
        for(int i=0;i<matrix.length;i++)//If matrix[i][j]=0, then we make matrix[i][0]=0 and matrix[0][j]=0. Basically we arr storing the row and column details in 0th row,0th column respectively.
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        
        for(int i=1;i<matrix.length;i++)//Exclude the 0th row. If matrix[i][0]=0, then we make that entire column as 0.
        {
           if(matrix[i][0]==0)
           {
               for(int j=0;j<matrix[i].length;j++)
               {
                   matrix[i][j]=0;
               }
           }
        }
        for(int j=1;j<matrix[0].length;j++)// Exclude the 0th column. If matrix[0][j]=0, then make the ith row as 0
        {
            if(matrix[0][j]==0)
            {
                for(int i=0;i<matrix.length;i++)
                {
                    matrix[i][j]=0;
                }
            }
        }
        
        //Till now we have dealt with all the rows except 0th row, all the columns except 0th column
        if(row)//Make the 0th row as all 0's
        {
            for(int i=0;i<matrix.length;i++)
            {
                matrix[i][0]=0;
            }
        }
        if(column)//Make the 0th column as all 0's
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                matrix[0][j]=0;
            }
        }
        
        
    }
}
/*
Time Complexity - O(n^2)
Space Complexity - O(1)
*/
