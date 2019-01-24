/*
977. Squares of a Sorted Array

https://leetcode.com/problems/squares-of-a-sorted-array/description/

Idea -- Used 2 pointers approach.
Find the point where positive values start, say i. Let j=i-1
So i is the starting position of positive values and j is the ending position of negative values.
Now square the values in the array.
If A[i]>A[j], then append A[j] to result and decrement j, else append A[i] and increment i.
There might be a case when i becomes equal to n, i.e., i=n. In that case we simply add the A[j] values to result till j becomes less than 0.
Similarly, if j=0, we simply add A[i] to result till i becomes N.

Inspired from
https://leetcode.com/problems/squares-of-a-sorted-array/solution/
*/
class Solution {
    public int[] sortedSquares(int[] A) {
        int i=0;//i and k are two pointers used in the solution
        int k=0;
        int n=A.length;
        int index=0;//index is for result array
        int result[]=new int[A.length];
        while(i<n && A[i]<0)//Finding the i i.e., index where positive values start
            i++;
        if(i==0)//i==0 means there all the values are positive. In this case, we square the values in A and return that array
        {
            for(int j=0;j<n;j++)
            {
                A[j]=A[j]*A[j];
            }
            return A;
        }
        else if(i==A.length)//It means that all the values are negative in A. So we add the squared values of A to result in reverse order and return result
        {
            
            for(int j=0;j<n;j++)
            {
                result[n-1-j]=A[j]*A[j];
            }
            return result;
        }
        else
        {
            k=i-1;//k points to last negative value
            for(int j=0;j<n;j++)
            {
                A[j]=A[j]*A[j];
            }
            while(i<n && k>=0)
            {
                if(A[i]<A[k])
                {
                    result[index++]=A[i++];
                }
                else
                {
                    result[index++]=A[k--];
                }
            }
            while(i<n)
                result[index++]=A[i++];
            while(k>=0)
                result[index++]=A[k--];
            return result;
        }
            
        
    }
}
/*
Time Complexity - O(n) where n is the length of the array A
Space Complexity - O(n) since we have used result array of size n
*/
