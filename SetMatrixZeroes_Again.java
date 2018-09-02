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
        boolean row=false,column=false;//row=true if matrix[i][0]==0
        for(int i=0;i<matrix.length;i++)
        {
            if(matrix[i][0]==0)
            {
                row=true;
                break;
            }
        }
        for(int j=0;j<matrix[0].length;j++)
        {
            if(matrix[0][j]==0)
            {
                column=true;
                break;
            }
        }
        //System.out.println(row+" "+column);
        for(int i=1;i<matrix.length;i++)//In the first column, make the values 0 if the corresponding row has atleast one 0 in it //In the first row, make the values 0 if the corresponsing column has atleast one 0 in it
        {
            for(int j=1;j<matrix[i].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        for(int i=1;i<matrix.length;i++)//If the first column element is 0, make the corresponding row all 0
        {
            if(matrix[i][0]==0)
            {
                for(int j=1;j<matrix[i].length;j++)
                {
                    matrix[i][j]=0;
                }
            }
        }
        
        for(int j=1;j<matrix[0].length;j++)//If the first row element is 0, make the corresponding column all 0
        {
            if(matrix[0][j]==0)
            {
                for(int i=1;i<matrix.length;i++)
                {
                    matrix[i][j]=0;
                }
            }
        }
        
        if(row)//if row=true, means initially there was atleast one 0 in the first row. So make the entire row =0
        {
            for(int i=0;i<matrix.length;i++)
            {
                matrix[i][0]=0;
            }
        }
        
        if(column)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                matrix[0][j]=0;
            }
        }
        
        // for(int i=0;i<matrix.length;i++)//display matrix
        // {
        //     for(int j=0;j<matrix[i].length;j++)
        //     {
        //         System.out.print(matrix[i][j]+" ");
        //     }
        //     System.out.println();
        // }
    }
}
/*
Time Complexity - O(m*n)
Space Complexity - O(1)
*/
