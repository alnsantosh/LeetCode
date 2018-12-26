/*
896. Monotonic Array

https://leetcode.com/problems/monotonic-array/description/

Idea - Travsrse through all the elements in the array and check if every adjacent pair is either increasing or decreasing monotonic
*/
class Solution {
    public boolean isMonotonic(int[] A) {
        if(A==null || A.length==0 || A.length==1)//base case
        {
            return true;
        }
        else
        {
            boolean greater=true;//greater tells if A[i-1]>A[i] (true case)
            if(A[0]>A[A.length-1])
                greater=false;
            for(int i=1;i<A.length;i++)
            {
                if(A[i-1]==A[i])//If the consecutive values are same, then simply ignore that case
                    continue;
                if(greater)//If greater, then check for each possible pair if A[i-1]<=A[i]. If not, return false.
                {
                    if(A[i-1]>A[i])
                        return false;
                }
                else//If greater==false, then check for each possible pair if A[i-1]>=A[i]. If not, return false.
                {
                    if(A[i-1]<A[i])
                        return false;
                }
            }
            return true;
        }
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
