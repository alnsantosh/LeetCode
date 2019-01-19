/*
229. Majority Element II

https://leetcode.com/problems/majority-element-ii/description/

Idea -- Store the occurence count of each element of nums[i] in a map and return the keys whose count is >nums.length/3


*/
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result=new ArrayList<>();
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        int min=nums.length/3;
        //System.out.println(min);
        for(int key:m.keySet())
        {
            //System.out.println(m.get(key));
            if(m.get(key)>min)
                result.add(key);
        }
        return result;
    }
}
/*
Time Complexity - O(n) where n is length of nums array
Space Complexity - O(n)
*/
