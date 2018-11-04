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
Idea - We know the ascii value of 'A','a','Z','z'. We can write our own logic for converting give string to lowercase.
*/
class Solution {
    public String toLowerCase(String str) {
        StringBuffer sb=new StringBuffer();//created string buffer since it is mutable
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)>='a' && str.charAt(i)<='z')//if lowercase, then directly append it to the string buffer
                sb.append(str.charAt(i));
            else
            {
                if(str.charAt(i)>='A' && str.charAt(i)<='Z')//if uppercase alphabet, then convert that into lowercase
                {
                    int index=str.charAt(i)-'A';
                    sb.append((char)(index+'a'));   
                }
                else//this else part is executed if the character is special character i.e., not an alphabet. We directly append such characters to the string buffer
                {
                    sb.append(str.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}
/*
Time Complexity - O(n) where n is length of the string
Space Complexity - O(n) - Created a string buffer
*/
