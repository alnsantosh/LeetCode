/*
917. Reverse Only Letters

https://leetcode.com/problems/reverse-only-letters/description/

Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.

 

Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 

Note:

S.length <= 100
33 <= S[i].ASCIIcode <= 122 
S doesn't contain \ or "
*/
/*
Idea - Store all the characters in stack. Create another string and add the characters accordingly i.e., iterate through all the characters in s, if the character in S is string, then append sb with the top element in stack. else add that character in S.
This will reverse all the letters in the string
*/
class Solution {
    public String reverseOnlyLetters(String S) {
        if(S==null || S.length()==0)
            return S;
        StringBuffer sb=new StringBuffer();
        Stack<Character> s=new Stack<>();
        for(int i=0;i<S.length();i++)
        {
            if(Character.isLetter(S.charAt(i)))
            {
                s.push(S.charAt(i));
            }
        }
        for(int i=0;i<S.length();i++)
        {
            if(Character.isLetter(S.charAt(i)))
            {
                sb.append(s.pop());
            }
            else
            {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}
/*
Time Complexity - O(n) - n is length of S
Space Complexity  - O(n) - Used Stack and StringBuffer
*/
