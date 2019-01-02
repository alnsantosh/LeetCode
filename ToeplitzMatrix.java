/*
766. Toeplitz Matrix

https://leetcode.com/problems/toeplitz-matrix/description/

Idea - For every index in matrix, compare the element matrix[i][j] with matrix[i-1][j-1]. If they do not match, then return false.Else return true at the end.

Inspired from
https://leetcode.com/problems/toeplitz-matrix/solution/
*/
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][j]!=matrix[i-1][j-1])
                    return false;
            }
        }
        return true;
    }
}
/*
Time Complexity - O(m*n) where m=matrix.length and n=matrix[0].length
Space Complexity -O(1)
*/
