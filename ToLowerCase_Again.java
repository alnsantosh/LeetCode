/*
709. To Lower Case

https://leetcode.com/problems/to-lower-case/description/

Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

 

Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"
*/
/*
Idea - For capital letters, covert them into small letters. For rest, append without any modification
*/
class Solution {
    public String toLowerCase(String str) {
        if(str==null || str.length()==0)
        {
            return str;
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if(c>='A' && c<='Z')
            {
                sb.append((char)(c-'A'+'a'));
            }
            else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
/*
Time Complexity - O(n) 
Space Complexity - O(n)(If I use string instead of stringbuffer, then everytime new string will be created when I append to it as string is immutable which will lead to 1*2*3* .... *n = n!(Space complexity as result of using String instead of StringBuffer))
*/
