
/*
55. Jump Game

https://leetcode.com/problems/jump-game/description/

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
*/
/*
traverse from right to left. Use vis[] (boolean array). vis[i] is true if nums[nums.length] can be reached from nums[i] in one or more steps.

mark the rightmost element in vis as true. start from nums.length-2 position(second last). move nums[i] steps forward for each i and if for any step if vis value is true, we make nums[i]=true and break the inner loop. We continue this process till i=0.
If vis[0]=true, means we can reach nums[nums.length-1] from nums[0]
*/
class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0)
            return true;
        boolean vis[]=new boolean[nums.length];
        vis[nums.length-1]=true;
        for(int i=nums.length-2;i>=0;i--)
        {
            for(int j=1;j<=nums[i];j++)
            {
                if(i+j>=nums.length)
                    break;
                if(vis[i+j])
                {
                    vis[i]=true;
                    break;
                }
            }
        }
        return vis[0];
    }
    
}
/*
Time Complexity - O(n) - as we move atmost one step forward in the internal loop
Space Complexity - O(n) - vis[] used
*/
