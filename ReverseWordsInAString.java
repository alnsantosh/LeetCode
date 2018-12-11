/*
151. Reverse Words in a String

https://leetcode.com/problems/reverse-words-in-a-string/description/

Given an input string, reverse the string word by word.

Example:  

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
Follow up: For C programmers, try to solve it in-place in O(1) space.
*/
/*
Idea - Use regular expresison and trim() function
*/
public class Solution {
    public String reverseWords(String s) {
        String[] words=s.trim().split("\\s+");//trim() remove leading and trailing extra whitespaces. \\s+ is regular expression which mean 1 or more white space.This gives us all the words
        for(int i=0;i<words.length;i++)
        {
            System.out.println(words[i]);
        }
        StringBuffer sb=new StringBuffer();
        for(int i=words.length-1;i>=0;i--)
        {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().substring(0,sb.length()-1);
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n) - Used array and StringBuffer
*/
