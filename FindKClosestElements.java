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
Idea - Find the index using binary search. Then find low, high sunh that high-low=2k. Then, gradually keep reducing high, increasing low such that the difference is minimum.

Explaination in leetcode solution page - The original array has been sorted so we can take this advantage by the following steps. 1. If the target x is less or equal than the first element in the sorted array, the first k elements are the result. 2. Similarly, if the target x is more or equal than the last element in the sorted array, the last k elements are the result. 3. Otherwise, we can use binary search to find the index of the element, which is equal (when this list has x) or a little bit larger than x (when this list does not have it). Then set low to its left k-1 position, and high to the right k-1 position of this index as a start. The desired k numbers must in this rang [index-k-1, index+k-1]. So we can shrink this range to get the result using the following rules. * If low reaches the lowest index 0 or the low element is closer to x than the high element, decrease the high index. * If high reaches to the highest index arr.size()-1 or it is nearer to x than the low element, increase the low index. * The looping ends when there are exactly k elements in [low, high], the subList of which is the result
*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res=new ArrayList<>();
        int index=Arrays.binarySearch(arr,x);
        if(index<0)
            index=-index-1;
        if(index<=0)
        {
            for(int i=0;i<k;i++)
                res.add(arr[i]);
            return res;
        }
        else if(index>=arr.length-1)
        {
            for(int i=arr.length-k;i<arr.length;i++)
                res.add(arr[i]);
            return res;
        }
        int low=Math.max(0,index-k-1),high=Math.min(arr.length-1,index+k-1);
        while(high-low>k-1)//This condition is essence
        {
            //System.out.println(low+" "+high);
            if(x-arr[low]>arr[high]-x)
            {
                low++;
            }
            else if(x-arr[low]<=arr[high]-x)
            {
                high--;
            }
        }
        for(int i=low;i<=high;i++)
            res.add(arr[i]);
        return res;
        
    }
}
/*
Time Complexity - O(logn + k), worst case k will be n.  So O(logn+n)=O(n)
Space Complexity - O(1) when res is not considered as extra memory
*/
