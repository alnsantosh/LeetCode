/*
784. Letter Case Permutation

https://leetcode.com/problems/letter-case-permutation/description/

Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]

Note:

    S will be a string with length at most 12.
    S will consist only of letters or digits.

*/
/*
Call recursively and update the string accordingly
(a1b2,0) => (a1b2,1) , (A1b2,1) since the char at pos 0 is character
*/
class Solution {
    List<String> res=new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        if(S.length()==0)
        {
            res.add(S);
        }
        else
            logic(S,0);
        return res;
    }
    public void logic(String s,int pos)
    {
        if(pos==s.length())
        {
            res.add(s);
            return;
        }
        char ch=s.charAt(pos);
        if(ch>='0' && ch<='9')
        {
            logic(s,pos+1);
        }
        else
        {
            StringBuffer sb=new StringBuffer(s);
            if(ch>='a' && ch<='z')
                sb.setCharAt(pos,Character.toUpperCase(ch));
            else
                sb.setCharAt(pos,Character.toLowerCase(ch));
            logic(s,pos+1);
            logic(sb.toString(),pos+1);
        }
    }
}
/*
Time Complexity - O(2^n) where n is number of characters in string
Space Complexity - O(n*(2^n)) - new string of length n is created everytime the logic() method is called
*/
