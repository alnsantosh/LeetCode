/*
409. Longest Palindrome

https://leetcode.com/problems/longest-palindrome/description/

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

*/
class Solution {
    public int longestPalindrome(String s) {
        int count=0;
        int odd=0;//to make sure if there is atleast one character of odd count
        Map<Character,Integer> m=new HashMap<>();//Store the counts in map
        for(int i=0;i<s.length();i++)
        {
            m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
        }
        for(Character ch:m.keySet())
        {
            if(m.get(ch)%2==0)//If %2. then add them in count
                count+=m.get(ch);
            else//else subtract 1 and add the count
            {
                odd=1;
                count+=m.get(ch)-1;
            }
        }
        if(odd==1)//if off count caracter exist, add 1 to the count
            count+=1;
        return count;
        
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1) -Since the map will have atmost 26+26(Capital letters + Small letters) elements in it along with its count.
*/
