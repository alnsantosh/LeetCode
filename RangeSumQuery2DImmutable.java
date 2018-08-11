/*
304. Range Sum Query 2D - Immutable

https://leetcode.com/problems/range-sum-query-2d-immutable/description/

Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:

Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12

Note:

    You may assume that the matrix does not change.
    There are many calls to sumRegion function.
    You may assume that row1 ≤ row2 and col1 ≤ col2.

*/
/*
Idea - https://leetcode.com/problems/range-sum-query-2d-immutable/solution/#
*/
class NumMatrix {
    int[][] data;
    public NumMatrix(int[][] matrix) {
        
        if(matrix.length==0 || matrix[0].length==0)
            return;
        int m=matrix.length,n=matrix[0].length;
        data=new int[m][n];
        data[0][0]=matrix[0][0];
        for(int i=1;i<m;i++)//fill the first row
        {
            data[i][0]=data[i-1][0]+matrix[i][0];
        }
        for(int i=1;i<n;i++)//fill the firs column
        {
            data[0][i]=data[0][i-1]+matrix[0][i];
        }
        for(int i=1;i<m;i++)//fill the remaining values with the sum
        {
            for(int j=1;j<n;j++)
            {
                data[i][j]=data[i-1][j]+data[i][j-1]-data[i-1][j-1]+matrix[i][j];
            }
        }
        
        // for(int i=0;i<data.length;i++)
        // {
        //     for(int j=0;j<data.length;j++)
        //     {
        //         System.out.print(data[i][j]+" ");
        //     }
        //     System.out.println();
        // }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1==0 && col1==0)
        {
            return data[row2][col2];
        }
        else if(row1==0)
        {
            return data[row2][col2]-data[row2][col1-1];
        }
        else if(col1==0)
        {
            return data[row2][col2]-data[row1-1][col2];
        }
        
        return data[row2][col2]-data[row1-1][col2]-data[row2][col1-1]+data[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

/*
Time Complexity - NumMatrix() - O(m*n), sumRegion -O(1)
Space Complexity - O(m*n)
*/
