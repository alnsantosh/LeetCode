/*
349. Intersection of Two Arrays

https://leetcode.com/problems/intersection-of-two-arrays/description/

Idea - Store the elements of nums1 in set s1. For every element in nums2, if it is present in nums1, store in s2. Transfer the values in s2 to result. Return the result


*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1=new HashSet<>();
        Set<Integer> s2=new HashSet<>();
        for(int i=0;i<nums1.length;i++)
        {
            s1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++)
        {
            if(s1.contains(nums2[i]))
            {
                s2.add(nums2[i]);   
            }
        }
        int[] result=new int[s2.size()];
        int k=0;
        for(int i : s2)
        {
            result[k++]=i;
        }
        return result;
    }
}
/*
Time Compelxity - O(n+m)
Space Complexity - O(n+m)
*/
