/*
 Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

Follow up:

    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //List<Integer> a=new ArrayList<>(); - Fails for i/p [1],[1 1] expected o/p - [1], If list is used, we get [1,1]. We need to handle the duplications
        // for(int i=0;i<nums1.length;i++)
        // {
        //     a.add(nums1[i]);
        // }
        if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0) // base cases
            return new int[]{};
        
        Map<Integer,Integer> m=new HashMap<>(); //adding nums1 in map so that duplication can be handled
        for(int i=0;i<nums1.length;i++)
        {
            if(m.containsKey(nums1[i]))
            {
                m.put(nums1[i],m.get(nums1[i])+1);
            }
            else
            {
                m.put(nums1[i],1);
            }
        }
        //printMap(m);
        List<Integer> b=new ArrayList<>(); //For each element in nums2, check if the element in present in map, if yes- add it to arraylist and decrement the count value in the map corresponding to that element and delete the element from map when it reaches zero
        for(int i=0;i<nums2.length;i++)
        {
            if(m.containsKey(nums2[i]))
            {
                b.add(nums2[i]);
                m.put(nums2[i],m.get(nums2[i])-1);
                if(m.get(nums2[i])<=0)
                    m.remove(nums2[i]);
            }
        }
        int[] res=new int[b.size()];
        for(int i=0;i<res.length;i++)
        {
            res[i]=b.get(i);
        }
        return res;
    }
    
    public static void print(Map m) { // to iterate through all the elements of the map
    Iterator it = m.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        System.out.println(pair.getKey() + " = " + pair.getValue());
    }
}
}

// Time complexity - O(n+n+n) - since three for loops
                // - O(n)
