/*
287. Find the Duplicate Number

https://leetcode.com/problems/find-the-duplicate-number/description/

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2

Example 2:

Input: [3,1,3,4,2]
Output: 3

Note:

    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once.


*/
/*
General Idea - We can use the concept of slow and fast pointer to find the cycle in a linked list. Here consider the array, we first find the point where the slow and fast pointer meet in the cycle. Eventually we find the first point in the cycle i.e., where the cycle begin.
That is the value which is repeated.
*/
class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0,fast=0;
        while(true)
        {
            slow=logic(nums,slow);
            fast=logic(nums,logic(nums,fast));
            if(slow==fast)
                break;
        }
        slow=0;
        while(slow!=fast)
        {
            slow=logic(nums,slow);
            fast=logic(nums,fast);
        }
        return slow;
    }
    public int logic(int[] nums,int k)
    {
        return nums[k];
    }
}
/*
Time Complexity - O(n) since all the elements are traversed
Space Complexity - O(1) since no extra space is used to store the elements of the array
*/
