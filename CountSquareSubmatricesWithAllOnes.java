/*
1277. Count Square Submatrices with All Ones
Idea: Using brute force.
For each cell in the matrix,finding all the squares possible with all 1's
*/
class Solution {
    public int countSquares(int[][] matrix) {
        int count=0;
        // display(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                for(int k=1;i+k<=matrix.length && j+k<=matrix[0].length;k++){
                    if(validSquare(matrix,i,j,k)){
                    System.out.println(i+" "+j+" "+k);
                    count++;    
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return count;
    }
    public boolean validSquare(int[][] matrix,int row,int col,int len){ // validSquare() checks if there are all 1's in the square within top left coordinates (row,col) and bottom right coordinates (row+len,col+len)
        for(int i=row;i<row+len;i++){
            for(int j=col;j<col+len;j++){
                if(matrix[i][j]!=1){
                    return false;
                }
            }
        }
        return true;
    }
    public void display(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
/*
Time Complexity: O(n*m*k) where n=number of rows, m=number of columns, k=min(n,m) (This value of k is the worst case value)
Space Complexity: O(1)
*/
