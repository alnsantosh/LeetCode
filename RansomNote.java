/*
383. Ransom Note

https://leetcode.com/problems/ransom-note/description/

Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/
/*
Idea - Use map to stire the characters in magazine string along with its count
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<magazine.length();i++)
        {
            m.put(magazine.charAt(i),m.getOrDefault(magazine.charAt(i),0)+1);
        }
        for(int i=0;i<ransomNote.length();i++)
        {
            if(m.containsKey(ransomNote.charAt(i)))
            {
                m.put(ransomNote.charAt(i),m.get(ransomNote.charAt(i))-1);
                if(m.get(ransomNote.charAt(i))==0)
                    m.remove(ransomNote.charAt(i));
            }
            else
                return false;
        }
        return true;    
    }
}
/*
Time Complexity - O(n) - Worst case when length of ransomNote m=length of magazone n
Space Complexity -O(n) where n is length of magazine string as Map is used to store the characters of magazine along with its count
*/
