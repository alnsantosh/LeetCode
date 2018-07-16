/*
844. Backspace String Compare

https://leetcode.com/problems/backspace-string-compare/description/

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
/*
Idea - Use two pointers i and j poiting to the end of each string.Have a count variable to track if there were any # so that we can skip those many non-# characters while going from right to left. Say, for String S, if we reach a string such that its not # and count associated with # is zero, then we break. We repeat same process for the other string. If those two character match, decrement i and j and continue the above process. Else, return false.
*/
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i=S.length()-1,j=T.length()-1,counti=0,countj=0;
        while(i>=0 || j>=0)
        {
            while(i>=0)
            {
                if(S.charAt(i)=='#')
                {
                    counti++;
                    i--;      
                }
                if(i>=0 && S.charAt(i)!='#' && counti>0)
                {
                    counti--;
                    i--;
                }
                else if(i>=0 && S.charAt(i)!='#' && counti==0)
                    break;
            }
            while(j>=0)
            {
                if(T.charAt(j)=='#')
                {
                    countj++;
                    j--;
                }
                if(j>=0 && T.charAt(j)!='#' && countj>0)
                {
                    countj--;
                    j--;
                }
                else if(j>=0 && T.charAt(j)!='#' && countj==0)
                    break;
            }
            //System.out.println(S.charAt(i)+" "+T.charAt(j)+" "+i+" "+j);
            if(i>=0 && j>=0)
            {
                if(S.charAt(i)!=T.charAt(j))
                    return false;
                else
                {
                    i--;
                    j--;
                    // if(i==-1 && j==-1)
                    //     return true;
                }
            }
            else if(i>=0 || j>=0)
                return false;
            
            
            
        }
        return true;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
