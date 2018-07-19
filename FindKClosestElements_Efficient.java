/*
658. Find K Closest Elements

https://leetcode.com/problems/find-k-closest-elements/description/

Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:

Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]

Example 2:

Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]

Note:

    The value k is positive and will always be smaller than the length of the sorted array.
    Length of the given array is positive and will not exceed 104
    Absolute value of elements in the array and x will not exceed 104

*/
/*
Idea - Use binary search with a little tweak
Very efficient solution
*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res=new ArrayList<>();
        int low=0,high=arr.length-1;
        int mid=low+(high-low)/2;
        while(low<high)
        {
            if(mid+k<arr.length && x-arr[mid]>arr[mid+k]-x)
            {
                low=mid+1;
            }
            else
                high=mid;
            mid=low+(high-low)/2;
        }
        for(int i=low;i<low+k;i++)
            res.add(arr[i]);
        return res;
    }
}
/*
Time Complexity - O(logn)
Space Complexity - O(1) if res is not considered as output memory, else O(n)
*/
