/*
859. Buddy Strings

https://leetcode.com/problems/buddy-strings/description/

Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.

 

Example 1:

Input: A = "ab", B = "ba"
Output: true

Example 2:

Input: A = "ab", B = "ab"
Output: false

Example 3:

Input: A = "aa", B = "aa"
Output: true

Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true

Example 5:

Input: A = "", B = "aa"
Output: false

 

Note:

    0 <= A.length <= 20000
    0 <= B.length <= 20000
    A and B consist only of lowercase letters.


*/
/*
Idea - Check if both the string are null,check the length - base cases
If A equals B, then we have to check if there is atleat once character in A which is repeated twice. If that is the case, then we can say that these elements can be swapped and we still get the same string. If there is no such character whose count is 0, return false.
If A not equals B, then we have to check if no. of mismatched characters is exactle 2. If more than 2 then return false. Else, check the A[i]==B[j] && A[j]==B[i] where i and j are the indices of the mismatched characters.
*/
class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A==null && B==null)
            return true;
        else if(A==null || B==null || A.length()!=B.length())
        {
            return false;
        }
        else if(A.equals(B))
        {
            Map<Character,Integer> m=new HashMap<>();
            for(int i=0;i<A.length();i++)
            {
                m.put(A.charAt(i),m.getOrDefault(A.charAt(i),0)+1);
            }
            for(char i:m.keySet())
            {
                if(m.get(i)>1)
                    return true;
            }
            return false;
            
        }
         int first=-1,second=-1;
        for(int i=0;i<A.length();i++)
        {
            if(A.charAt(i)!=B.charAt(i))
            {
                if(first==-1)
                {
                    first=i;
                }
                else if(second==-1)
                {
                    second=i;
                }
                else
                {
                    return false;
                }
            }
        }
        
        if(first!=-1 && second!=-1 && A.charAt(first)==B.charAt(second) && A.charAt(second)==B.charAt(first))
            return true;
        return false;
    }
}
/*
Time Complexity - O(n)
Space Complexity -O(1) - Used map but that will have atmost 26 values in it
*/
