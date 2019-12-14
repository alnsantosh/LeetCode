/*
1207. Unique Number of Occurrences
Idea: Store the counts in a map and then store the map values i.e the counts in HashSet. If the map size = hashset size, return true. Else, return false.
*/
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            m.put(arr[i],m.getOrDefault(arr[i],0)+1);
        }
        if(m.size()==new HashSet<>(m.values()).size())
       {
           return true;
       }
       return false;
    }
}
/*
Time Complexity: O(n) where n is length of arr
Space Complexity: O(n) (worst case, all the elements in the arr are unique, then map size will be equal to n)
*/
