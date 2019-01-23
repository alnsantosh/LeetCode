/*
977. Squares of a Sorted Array

https://leetcode.com/problems/squares-of-a-sorted-array/description/

Idea -- Square each element in the array ans then sort the array based on the squared values.
*/
class Solution {
    public int[] sortedSquares(int[] A) {
        for(int i=0;i<A.length;i++)
        {
            A[i]=A[i]*A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
/*
Time Complexity - O(nlog(n))
Space Complexity - O(n)
*/
