/*
303. Range Sum Query - Immutable

https://leetcode.com/problems/range-sum-query-immutable/description/

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:

Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:

    You may assume that the array does not change.
    There are many calls to sumRange function.

*/
class NumArray {
    public int[] data;
    public NumArray(int[] nums) {//preprocessing in O(n) time. data[i] stores sum of all the elements in nums from index 0 to i
        data=new int[nums.length];
        if(nums.length!=0)
            data[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            data[i]=nums[i]+data[i-1];
        }
    }
    
    public int sumRange(int i, int j) {//takes O(1) time to return the sum of the range of elements in the array
        if(data.length==0)
            return 0;
        if(i==0)
            return data[j];
        return data[j]-data[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
/*
Time Complexity - O(n) for preprocessing in NumArray() constructor, O(1) for sumRange() method
Space Complexity - O(n) since creating data array
*/
