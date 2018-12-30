/*
922. Sort Array By Parity II

https://leetcode.com/problems/sort-array-by-parity-ii/description/

Idea - If we correct the values in even places, odd places will automatically be corrected.
Basically for every even location,swap the values which does not meet the constraint.

For clear understanding
https://leetcode.com/problems/sort-array-by-parity-ii/solution/
*/
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int j=1;
        for(int i=0;i<A.length;i++)
        {
            if(i%2==0)
            {
                if(A[i]%2!=0)
                {
                    while(A[j]%2!=0)
                    {
                        j+=2;
                    }
                    int temp=A[i];
                    A[i]=A[j];
                    A[j]=temp;
                }
            }
        }
        return A;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
