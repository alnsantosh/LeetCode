/*
867. Transpose Matrix

https://leetcode.com/problems/transpose-matrix/description/

Idea -- Create a new array result with the transpose dimensions
Simply update the values in result based on values of A


*/
class Solution {
    public int[][] transpose(int[][] A) {
        if(A==null || A.length==0)
            return A;
        int m=A.length,n=A[0].length;
        int result[][]=new int[n][m];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                result[j][i]=A[i][j];
            }
        }
        return result;
    }
}
/*
Time Complexity - O(n*m)
Space Complexity - O(n*m) if result is considered as extra space
*/
