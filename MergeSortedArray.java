/*
88. Merge Sorted Array

https://leetcode.com/problems/merge-sorted-array/description/

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/
/*
Idea - start from the last of the array and keep adding elements to the nums1 based on element comparison in both the arrays. This way we will not have any issues of overlapping etc which we will face if we start from left towards right.
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1;
        int k=nums1.length-1;
        while(i>=0 && j>=0)//This misses the case when all the elelments in nums1 are included but nums2 not covered, In such a case, nums2 element are still not covered. So we need to traverse through the remaining elements in nums2 and put them them in nums1
        {
            if(nums1[i]>=nums2[j])
            {
                nums1[k]=nums1[i];
                i--;
                k--;
            }
            else
            {
                nums1[k]=nums2[j];
                j--;
                k--;
            }
        }
        while(j>=0)//Making sure that all the elements in nums2 are covered
        {
            nums1[k--]=nums2[j--];
        }
        
    }
}
/*
Time Complexity - O(n+m)
Space Complexity - O(1)
*/
