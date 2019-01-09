/*
718. Maximum Length of Repeated Subarray

https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/

Idea -- If ith element in A=jth element in B, then A[i][j]=A[i-1][j-1]+1

Inspired from
https://leetcode.com/problems/maximum-length-of-repeated-subarray/solution/
*/
class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] dp=new int[A.length+1][B.length+1];//dp dimension is [A.length+1][B.length+1] instead of [A.length][B.length] as it will ease the calculations. The first row and column will all be zeroes.
        int res=0;
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(A[i-1]==B[j-1])//i and j started from 1, so in order to map this to the given strings A and B, we are comparing A[i-1] to B[j-1]
                {
                    dp[i][j]=dp[i-1][j-1]+1;//If i looped from 0 to dp.length-1 and j looped from 0 to dp[0].length-1, then we can use dp[i+1][j+1]=dp[i][j]+1;
                }
                if(dp[i][j]>res)
                    res=dp[i][j];
            }
        }
        return res;
    }
}
/*
Time Complexity - O(m*n) where m=length of A, n=length of B
Space Complexity - O(m*n) since dp[][] array is used
*/
