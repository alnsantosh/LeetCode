/*
905. Sort Array By Parity

https://leetcode.com/problems/sort-array-by-parity/description/

Idea -- Use additional array to store the even and odd values accordingly


*/
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] res=new int[A.length];
        int j=0,k=A.length-1;
        for(int i=0;i<A.length;i++)
        {
            if(A[i]%2==0)
            {
                res[j++]=A[i];
            }
            else
            {
                res[k--]=A[i];
            }
        }
        return res;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n)
*/
