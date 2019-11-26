/*
1. Two Sum

*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m=new HashMap<>();
        int[] res=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            m.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(target-nums[i]) && m.get(target-nums[i])!=i){
                res[0]=i;
                res[1]=m.get(target-nums[i]);
            }
        }//The above two for loops can be combined
        return res;
    }
}
/*
Time Complexity - O(n) where n is length of nums
Space Complexity - O(n) where n is length of nums
*/
