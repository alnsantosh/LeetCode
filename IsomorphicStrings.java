/*
205. Isomorphic Strings

https://leetcode.com/problems/isomorphic-strings/description/

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
*/
/*
Idea - Use two maps such that m1 stores characters of s as key and corresponding characters in t as values. However m2 stores characters in t as key and the corresponding characters in s as value
Let s-character = ith character in s
t-character = ith character in t
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Set<Character> sSet=new HashSet<>();  //Wrong approach(Commented part) - Here I just counted the unique characters from both the strings and checked if the unique characters iin both the strings are equal or not. Here I missed the order of the characters in the string eg: "aab","aba"
        // for(int i=0;i<s.length();i++)
        // {
        //     sSet.add(s.charAt(i));
        // }
        // Set<Character> tSet=new HashSet<>();
        // for(int i=0;i<t.length();i++)
        // {
        //     tSet.add(t.charAt(i));
        // }
        // return sSet.size()==tSet.size();
        
        Map<Character,Character> m1=new HashMap<>();
        Map<Character,Character> m2=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            if(m1.containsKey(s.charAt(i)) && m2.containsKey(t.charAt(i)))//If the s-character present in m1 and t-character present in m2
            {
                //System.out.println(m1.get(s.charAt(i))==t.charAt(i));
                if(m1.get(s.charAt(i))==t.charAt(i) && m2.get(t.charAt(i))==s.charAt(i))//It means that they are mapped bijunctively to each other
                {
                    continue;
                }
                else//If there is no proper mapping
                {
                    return false;
                }
            }
            else if(m1.containsKey(s.charAt(i)) || m2.containsKey(t.charAt(i)))//If only one of the maps m1 or m2 contains the s-character , t-character respectively as key, then we direcctly return false
                return false;
            else//We baically put the key-value pair in map m1,m2
            {
                m1.put(s.charAt(i),t.charAt(i));
                m2.put(t.charAt(i),s.charAt(i));
            }
        }
        return true;
    }
}
/*
Time Complexity - O(n) - where n=length of string s and t (Given: s and t are of same length)
Space Complexity - O(n) - Used two maps
*/
