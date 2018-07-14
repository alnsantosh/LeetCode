/*
844. Backspace String Compare

Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

Note:

    1 <= S.length <= 200
    1 <= T.length <= 200
    S and T only contain lowercase letters and '#' characters.

Follow up:

    Can you solve it in O(N) time and O(1) space?


*/
class Solution {
    public boolean backspaceCompare(String S, String T) {
        if(S.length()==0 && T.length()==0)
            return true;
        else if(S.length()==0 || T.length()==0)
            return false;
        else
        {
            String str1=logic(S);
            String str2=logic(T);
            return str1.equals(str2);
        }
        
    }
    public String logic(String s)//Used stack
    {
        Stack<Character> s1=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch!='#')
            {
                s1.push(ch);
            }
            else
            {
                if(!s1.empty())
                {
                    s1.pop();
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!s1.empty())
        {
            sb.append(s1.pop());
        }
        return sb.toString();
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n)
*/
