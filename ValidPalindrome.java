/*
125. Valid Palindrome

https://leetcode.com/problems/valid-palindrome/description/

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:

Input: "race a car"
Output: false


*/
class Solution {
    public boolean isPalindrome(String s) {
        int left=0,right=s.length()-1;
        while(left<=right)
        {
            if(!Character.isLetterOrDigit(s.charAt(left)))
            {
                left++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(right)))
            {
                right--;
            }
            else
            {
                if(Character.toLowerCase(s.charAt(left))==Character.toLowerCase(s.charAt(right)))
                {
                    left++;
                    right--;
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
