/*
905. Sort Array By Parity

https://leetcode.com/problems/sort-array-by-parity/description/

Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 

Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000
*/
/*
Idea - Create a res of length =A.length.
Now iterate through all the elements of the array and place the array elements in res accordingly.
*/
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] res=new int[A.length];
        int i=0;//i and j are to place the elements of A in res at beginning and ending respectively.
        int j=A.length-1;
        int index=0;//Track the current position of A
        while(i<j || index<A.length)
        {
            if(A[index]%2==0)
            {
                res[i]=A[index];
                i++;
                index++;
            }
            else
            {
                res[j]=A[index];
                j--;
                index++;
            }
        }
        return res;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n) - If the res[] array is considered as extra space. Else O(1)
*/
