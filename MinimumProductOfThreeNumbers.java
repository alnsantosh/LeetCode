/*
628. Maximum Product of Three Numbers

https://leetcode.com/problems/maximum-product-of-three-numbers/

Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6
Example 2:
Input: [1,2,3,4]
Output: 24
Note:
The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
*/
/*
Idea - Sort the array. Noe check if the product of largest three numbers > (product of largesr number and smallest two numbers)
Return the bigger value

Reaon of checking lowest two values is to cover -ve numbers.
Consider the case [-10,-9,0,1,2,3]
in this case prod1=6, but prod2=270
Hence we return 270
In simple words, if the array has -ve numbers, then we have to check the possibility that -ve*-ve*+vw could be a much bigger number
*/
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int prod1=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int prod2=nums[nums.length-1]*nums[0]*nums[1];
        //System.out.println(prod1+" "+prod2);
        return (prod1>=prod2)?prod1:prod2;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
