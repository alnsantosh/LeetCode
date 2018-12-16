/*
867. Transpose Matrix

https://leetcode.com/problems/transpose-matrix/description/

Given a matrix A, return the transpose of A.

The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.

 

Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:

Input: [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
 

Note:

1 <= A.length <= 1000
1 <= A[0].length <= 1000
*/
/*
Idea - Create a new array with dimensions based on A. Now traverse through all the element in A and copy those values in appropriate position in res
*/
class Solution {
    public int[][] transpose(int[][] A) {
        int m=A.length;
        int n=A[0].length;
        int[][] res=new int[n][m];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                res[j][i]=A[i][j];
            }
        }
        return res;
    }
}
/*
Time Complexity - O(m*n)
Space Complexity - O(m*n)
*/


//The following code would be correct if the m=n. However when m!=n, it will throw array out of bounds exception

/*
Idea - Iterate over Upper Traingular Matrix and swap every value with the corresponding value in the lower triangular matrix
*/

// class Solution {
//     public int[][] transpose(int[][] A) {
//         int m=A.length;
//         int n=A[0].length;
//         for(int i=0;i<m;i++)
//         {
//             for(int j=i+1;j<n;j++)
//             {
//                 int temp=A[i][j];
//                 A[i][j]=A[j][i];
//                 A[j][i]=temp;
//             }
//         }
//         return A;
//     }
// }

/*
Time Complexity - O(m*n)
Space Complexity - O(1)
*/
