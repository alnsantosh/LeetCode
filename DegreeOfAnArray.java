/*
697. Degree of an Array

https://leetcode.com/problems/degree-of-an-array/description/

Idea - For each unique value,store the left index,right index and count in seperate maps. For the largest count value, return the least right-left index value.

Inspired from
https://leetcode.com/problems/degree-of-an-array/solution/
*/
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> left=new HashMap<>();//leftmost index for each unique value in nums
        Map<Integer,Integer> right=new HashMap<>();//rightmost index for each unique value in nums
        Map<Integer,Integer> count=new HashMap<>();//count of each unique value in nums
        for(int i=0;i<nums.length;i++)//logic to fill the maps with appropriate values
        {
            if(!left.containsKey(nums[i]))
            {
                left.put(nums[i],i);
            }
            if(!right.containsKey(nums[nums.length-1-i]))
            {
                right.put(nums[nums.length-1-i],nums.length-1-i);
            }
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
        }
        int degree=0,length=0;//degree stores the highest count value and length stores the corresponding difference between left and right index of that value
        for(int key:count.keySet())
        {
            int d=count.get(key);
            //System.out.println(key+" "+d);
            if(d>degree)
            {
                degree=d;
                length=right.get(key)-left.get(key)+1;
            }
            else if(d==degree)
            {
                int l=right.get(key)-left.get(key)+1;
                if(l<length)
                    length=l;
            }
        }
        //System.out.println(degree);
        return length;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n) - Used map for left,right and count
*/
