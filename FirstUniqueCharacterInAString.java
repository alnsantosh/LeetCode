/*
387. First Unique Character in a String

https://leetcode.com/problems/first-unique-character-in-a-string/description/

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/
/*
Idea - Use map to store the counts of each character in the string.
Now iterate through all the elements of the string and check if the count in the map is 1. Return the forst character with count 1. If no such character, then return -1.
*/
class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<s.length();i++)
        {
            if(m.get(s.charAt(i))==1)
                return i;
        }
        return -1;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n) - Used map
*/
