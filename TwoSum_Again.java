/*
1. Two Sum

https://leetcode.com/problems/two-sum/description/

Idea - Use HashMap to store the values and index of the array
Single pass is enough for the two sum


*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m=new HashMap<>();
        int result[]=new int[2];
        if(nums==null || nums.length==0)
            return result;
        for(int i=0;i<nums.length;i++)
        {
            if(m.containsKey(target-nums[i]) && i!=m.get(target-nums[i]))
            {
                
                {
                    result[1]=i;
                    result[0]=m.get(target-nums[i]);
                }
                return result;
            }
            m.put(nums[i],i);
        }
        return result;
    }
}

/*
Time Complexity - O(n)
Space Complexity - O(n) Used HashMap
*/
