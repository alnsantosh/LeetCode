/*
242. Valid Anagram

https://leetcode.com/problems/valid-anagram/description/

Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

*/
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<t.length();i++)
        {
            if(!m.containsKey(t.charAt(i)) || m.get(t.charAt(i))==0)
                return false;
            else
            {
                m.put(t.charAt(i),m.get(t.charAt(i))-1);
            }
        }
        for(char c:m.keySet())
        {
            if(m.get(c)>0)
                return false;
        }
        return true;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1) - Using hashmap but the hashmap will contain atmost 26 values in it i.e., all the alphabet characters
*/
