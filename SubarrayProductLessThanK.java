/*
713. Subarray Product Less Than K

https://leetcode.com/problems/subarray-product-less-than-k/description/

Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:

Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

Note:
0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.
*/
/*
Basic Idea - We can use sliding window approach. Take two pointers i and j. i is to iterate through all the elements in the array. so initially i=0,j=0; we take a variable prod and sum. when prod>=100, we increment j untill prod<100. 
*/
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)
            return 0;
        int j=0;
        //int count=0;
        int sum=0;
        int prod=1;
        for(int i=0;i<nums.length;i++)
        {
            prod*=nums[i];
            // if(prod<k)
            //     count++;
            // else
            while(prod>=k)
            {
                //sum+=(count*(count+1))/2;
                //count=0;
                prod/=nums[j];
                j++;
            }
            sum+=i-j+1;
            //System.out.println("i: "+i+" j:"+j+" sum: "+sum+" prod: "+prod);
        }
        return sum;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
