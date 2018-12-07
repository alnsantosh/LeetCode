/*
832. Flipping an Image

https://leetcode.com/problems/flipping-an-image/description/

Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

Example 1:

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
Example 2:

Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Notes:

1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1
*/
/*
Idea - We can do it inplace
To reverse the elements in the array in place, we have to swap first and last element, the second and second last element and so on. We do that for each row
While doing that, we also inverse the bit by using ^ operation i.e., x^1= ~x. so we use ^1 while updating the value of A[i][j] and A[n-i-j]

A[n-1-j], Here n-1 points to last index. So n-1-j helps traversing back in each row

Note - For j, we have to make sure that we are including middle element in each row in case of odd numbers of elements in each row
j<(n+1)/2 has to be considered as terminating condition instead of j<n/2(as j<n/2 will not include the middle value in case of odd number of elements in the row. So the middle element value will not be inverted)
*/
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int m=A.length;
        int n=A[0].length;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<(n+1)/2;j++)
            {
                int temp=A[i][j];
                A[i][j]=A[i][n-1-j]^1;
                A[i][n-1-j]=temp^1;
            }
        }
        return A;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
/*
Test case - [[1,1,0],[1,0,1],[0,0,0]]

*/
