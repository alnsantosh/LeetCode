/*
1252. Cells with Odd Values in a Matrix
Idea: Straight forward approach. For each indices[i], increment matrix rows and columns accordingly. Finally count the number of cells with odd values.
*/
class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int res=0;
        int[][] matrix=new int[n][m];
        for(int i=0;i<indices.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[indices[i][0]][j]+=1;
            }
            for(int j=0;j<matrix.length;j++){
                matrix[j][indices[i][1]]+=1;
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]%2!=0){
                    res++;
                }
            }
        }
        return res;
    }
}
/*
Time Complexity: O(n*k+m*k+n*m) where n=number of rows in matrix, m=number of columns in matrix, k=number of rows in indices
Space Complexity: O(n*m) since matrix[n][m] is created
*/
