/*
852. Peak Index in a Mountain Array

https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

Let's call an array A a mountain if the following properties hold:

A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

Example 1:

Input: [0,1,0]
Output: 1
Example 2:

Input: [0,2,1,0]
Output: 1
Note:

3 <= A.length <= 10000
0 <= A[i] <= 10^6
A is a mountain, as defined above.

*/
/*
Idea - Used binary search approach.
Check if the mid value is greater than mid-1 and mid+1. If true, return mid. Else, check if value in mid-1>mid, if true, then it means that the peak lies on the left side of the mid. So we call the method recursively on the left part of the mid. If value in mid+1>mid, then it means that the peak lies on the right side of the mid, so we call the method recursively on the right side of the mid.
*/
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        return logic(0,A.length-1,A);
    }
    public int logic(int low,int high,int[] A)
    {
        if(low>high)
            return 0;
        int mid=(low+high)/2;
        if(A[mid]>A[mid-1] && A[mid]>A[mid+1])
            return mid;
        else if(A[mid]<A[mid-1])
        {
            return logic(low,mid-1,A);
        }
        else
        {
            return logic(mid+1,high,A);
        }
        
    }
}
/*
Time Complexity - O(log(n)) - Used binary search
Space Complexity - O(1)
*/
