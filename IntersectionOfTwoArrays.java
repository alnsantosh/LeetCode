//349. Intersection of Two Arrays
/*
 Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:

    Each element in the result must be unique.
    The result can be in any order.

*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<nums1.length;i++)
            s.add(nums1[i]);
         Set<Integer> s2=new HashSet<>();
        for(int i=0;i<nums2.length;i++)
        {
            if(s.contains(nums2[i]))//if s contains nums2[i], then add it to s2
            {
                s2.add(nums2[i]);
            }
        }
        //int res[]= s.toArray(new Integer[s.size()]);
        int res[]=new int[s2.size()];
        Iterator<Integer> it=s2.iterator(); //Using iterator for travesring HashSet
        int i=0;
        while(it.hasNext())
        {
            res[i++]=(int)it.next();
        }
        return res;
        //return new ArrayList<Integer>(s).toArray();
        
    }
}

/*
Complexity-
Time- O(n) where n is length of the array
Space - O(n) 
*/
