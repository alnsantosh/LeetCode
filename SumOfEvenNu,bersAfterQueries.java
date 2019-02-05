/*
985. Sum of Even Numbers After Queries

https://leetcode.com/problems/sum-of-even-numbers-after-queries/description/

Idea -- First calculate the sum of the even values in A and store in sum
Now traverse through queries array. For each query, 
1. check if the A[queries[i][1]] value is even, if true then subtract that values from sum
2. Add queries[i][0] to A[queries[i][1]] and check if the A[queries[i][1]] value is even, if true then add that values from sum. Finally store that value in result array.
Repeat the above procedure for all the queries


*/
class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum=0;
        for(int i=0;i<A.length;i++)
        {
            if(A[i]%2==0)
            {
                sum+=A[i];
            }
        }
        int[] result=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            if(A[queries[i][1]]%2==0)
            {
                sum-=A[queries[i][1]];
            }
            A[queries[i][1]]+=queries[i][0];
            if(A[queries[i][1]]%2==0)
            {
                sum+=A[queries[i][1]];
            }
            result[i]=sum;
        }
        return result;
    }
}
/*
Time Complexity - O(n+m) where n is length of array A and m is length of array queries
Space Complexity - O(m) if result array is considered as extra space
*/
