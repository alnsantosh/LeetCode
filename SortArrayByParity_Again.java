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
Idea - We can swap the values inplace to get the desired output
2 pointer based approach
Let i=0, j=A.length-1
Now increment i till we get A[i] which is not divisible by 2
Similarly decrement j such that we get A[j] which is divisible by 2
Now swap these values and increment i and decrement j
Repeat the process untill i<j condition fails.
*/
class Solution {
    public int[] sortArrayByParity(int[] A) {
        if(A==null || A.length==0)
            return A;
        int i=0,j=A.length-1;
        while(i<j)
        {
            while(i<j && A[i]%2==0)
            {
                i+=1;
            }
           
            while(i<j && A[j]%2!=0)
            {
                j-=1;
            }
            if(i<j)
            {
                int temp=A[i];
                A[i]=A[j];
                A[j]=temp;
                i++;
                j--;
            }    
        }
        return A;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1) - Swapped the values inplace
*/
