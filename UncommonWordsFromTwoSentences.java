/*
884. Uncommon Words from Two Sentences

https://leetcode.com/problems/uncommon-words-from-two-sentences/description/


Idea - Basically we have to parse both the string and return the words which occured exactly once. This can be acheived by using a map.
Simply add the words to the reult whose count is 1 in the map. Edge case would be if there is no uncommon word at all, we have to return an empty String array.


*/
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String,Integer> m=new HashMap<>();
        String[] a=A.split(" ");
        String[] b=B.split(" ");
        StringBuffer result=new StringBuffer();
        for(String str:a)
        {
            m.put(str,m.getOrDefault(str,0)+1);
        }
        for(String str:b)
        {
            m.put(str,m.getOrDefault(str,0)+1);
        }
        for(String key:m.keySet())
        {
            if(m.get(key)==1)
                result.append(key).append(" ");
        }
        //System.out.println(result.length());
        if(result.length()==0)
            return new String[0];
        return result.toString().split(" ");
    }
}
/*
Time Complexity - O(n+m) where n is length of A and m is length of B
Space Complexity - O(n+m) since we have used map and string arrays
*/
