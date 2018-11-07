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

S will be a string with length between 1 and 12.
S will consist only of letters or digits.
*/
class Solution {
    List<String> res=new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        if(S==null)
            return res;
        logic(S,0);
        return res;
        
    }
    public void logic(String S,int pos)
    {
        if(pos==S.length())
        {
            res.add(S);
            return;
        }
            
        else if(S.charAt(pos)>='0' && S.charAt(pos)<='9')
            logic(S,pos+1);
        else
        {
            StringBuffer sb=new StringBuffer(S);
            if(S.charAt(pos)>='a' && S.charAt(pos)<='z')
            {
                sb.setCharAt(pos,Character.toUpperCase(S.charAt(pos)));
            }
            else
            {
                sb.setCharAt(pos,Character.toLowerCase(S.charAt(pos)));
            }
            logic(S,pos+1);
            logic(sb.toString(),pos+1);
        }
    }
}
/*
Time Complexity - O(2^n) - Looking for all the possible cases
Space Complexity - O(n*n) - The recusive stack will go to a depth equal to the length of the string So O(n). Also inside logic() function we are creating a StringBuffer sb which is of length n
*/
/*
One of the edge case
Input - ""
Output - [""]
*/
