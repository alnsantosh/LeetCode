/*
78. Subsets

https://leetcode.com/problems/subsets/description/

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


*/
/*
Idea - The total sets in powerset = 2^n. (Since each element in the given input set can be included or not included)
Total elements in the given input set = n

Refer https://www.geeksforgeeks.org/power-set/
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        int total=(int)Math.pow(2,n);
        for(int i=0;i<total;i++)
        {
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                if((i & 1<<j) >0)
                {
                    temp.add(nums[j]);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
/*
Time Complexity - O(n*2^n)
Space Complexity - O(n*2^n) - If res is considered in space complexity, else O(n) if only temp is considered as extra space
*/
