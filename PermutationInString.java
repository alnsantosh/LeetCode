/*
567. Permutation in String

https://leetcode.com/problems/permutation-in-string/description/

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

Example 1:

Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False

Note:

    The input strings only contain lower case letters.
    The length of both given strings is in range [1, 10,000].

*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        else
        {
            int start=0,end=0;
            int count;
            Map<Character,Integer> m=new HashMap<>();
            for(int i=0;i<s1.length();i++)
            {
                m.put(s1.charAt(i),m.getOrDefault(s1.charAt(i),0)+1);
            }
            count=m.size();
            while(end<s2.length())
            {
                char ch=s2.charAt(end);
                if(m.containsKey(ch))
                {
                    m.put(ch,m.get(ch)-1);
                    if(m.get(ch)==0)
                        count--;
                }
                end++;
                while(count==0)
                {
                    //System.out.println(end-start+" "+);
                    if(end-start==s1.length())
                        return true;
                    char tmp=s2.charAt(start);
                    if(m.containsKey(tmp))
                    {
                        if(m.get(tmp)==0)
                            count++;
                        m.put(tmp,m.get(tmp)+1);
                    }
                    start++;
                }
            }
            return false;
        }
    }
}
/*
Time Complexity - O(n) - where n is thr length of the longer string s2
Space Complexity - O(1) - since the map will have atmost 26 entries
*/
