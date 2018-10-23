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
Idea - use two pointers logic
Consider the following example
nums = [10, 5, 2, 6], k = 100
Initially i=0,j=0;
at each step, I am trying to find the number of possible combinations we can get with the last ith element compulsory in it.
So initially i is pointing to 10.j is also pointing at 10. So the total ways to get a array between i and j= 1 i.e., [10]
Since the product is less that 100, increment i
Now i points to 5, j points to 10
Now we need to find the the possible subarrays in array with i and j as extreme ends i.e., we need to find all the subarrays in [10,5] such that 5 occurs always. There are only 2 ways for that [5],[10,5]. We add this to the count
count+=(i-j)+1
Here (i-j)+1 gives us the count of subarrays with ith element included in the end.
We continue the above process for the rest of the array.

*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)
            return 0;
        int i=0,j=0;
        int prod=1;//stores the product between all the elements of i and j
        int count=0;//stores the final count
        while(j<=i && i<nums.length)
        {
            //System.out.print(i+" "+j);
            prod*=nums[i];
            while(prod>=k)//while here as we have to increment j untill the product is <k
            {
                //prod/=nums[i];
                prod/=nums[j];
                j++;
            }
            count+=(i-j)+1;
            i++;
        }
        return count;
    }
}
/*
Time Complexity - O(n) - Iterating over the array once
Space Complexity - O(1)
*/
