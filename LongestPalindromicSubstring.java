/*
5. Longest Palindromic Substring

https://leetcode.com/problems/longest-palindromic-substring/description/

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/
class Solution {
    public String longestPalindrome(String s) {
        
        if(s.equals("") || s==null)//edge case
            return "";
        int max=0;
        String res=null;
        for(int i=0;i<s.length();i++)//we have to check for even and odd palindromes
        {
            
            //For odd palindromes eg:aba. We take each element as center of the palindrome and traverse left and right one step at a time and check if the resultant string is palindrome. We do this till either it goes beyond string length or if the palindrome case fails
            int low=i,high=i;
            while(s.charAt(low)==s.charAt(high))
            {
                low--;
                high++;
                if(low<0 || high>=s.length())
                {
                    break;
                }
            }
            int len=high-low+1;
            if(len>max)
            {
                max=len;
                res=s.substring(low+1,high);
            }
            
            //For even palindrome eg: abbc. Here, we compare each element with the next element. If they match, we decrement low and increment high and compare those characters. We carry on this process till either palindrome condition fails or (low<0 || high>=s.length)
            low=i;
            high=i+1;
            if(high>=s.length())
                {
                    continue;
                }
            while(s.charAt(low)==s.charAt(high))
            {
                low--;
                high++;
                if(low<0 || high>=s.length())
                {
                    break;
                }
            }
            len=high-low+1;
            if(len>max)
            {
                max=len;
                res=s.substring(low+1,high);
            }
            
        }
        return res;
    }
    
   /* public String logic(String s,int low,int high)
    {
            int low=i,high=i;
            while(s.charAt(low)==s.charAt(high))
            {
                low--;
                high++;
                if(low<0 || high>=s.length())
                {
                    break;
                }
            }
            int len=high-low+1;
            if(len>max)
            {
                max=len;
                res=s.substring(low+1,high);
            }
        }
        return res;*/
    //}
}

/*
Time Complexity - O(n^2) - n for iterating through each element. Another n for moving left and right from every point
Space Complexity - O(1)
*/
