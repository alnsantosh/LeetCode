/*
520. Detect Capital

https://leetcode.com/problems/detect-capital/description/

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.


*/
/*
Idea - Traverse through all the elements in the array
*/
class Solution {
    public boolean detectCapitalUse(String word) {
        int n=word.length()-1;
        if(word.charAt(n)>='A' && word.charAt(n)<='Z')//If the last letter is capital, check if all the other letters are capital or not. If all are capital, we can return true, else return false;
        {
            for(int i=0;i<n;i++)
            {
                if(!(word.charAt(i)>='A' && word.charAt(i)<='Z'))
                    return false;
            }
            return true;
        }
        else//If the last letter is not capital, check if all the elements except 1st letter are in lower case or not. If all in lower case, return true, else false. Here we need not care about 0th index in string as it can be lower or upper case, given that last character is lower case.
        {
            for(int i=1;i<n;i++)
            {
                if(!(word.charAt(i)>='a' && word.charAt(i)<='z'))
                    return false;
            }
            return true;
        }
        
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
