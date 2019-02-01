/*
345. Reverse Vowels of a String

https://leetcode.com/problems/reverse-vowels-of-a-string/description/

Idea -- Use two pointer approach. One at the beginning and other at the end of the stringbuffer.
Check if the character is vowel or not and appropriately increment i and decrement j
When both i and j are pointing to a vowel, swap the characters at i and j.
Increment i and decrement j.


*/
class Solution {
    public String reverseVowels(String s) {
        int i=0,j=s.length()-1;
        StringBuffer sb=new StringBuffer(s);
        //long l=0;
        while(i<j)
        {
            while(i<j && !isVowel(sb.charAt(i)))
            {
                i++;
            }
            while(i<j && !isVowel(sb.charAt(j)))
            {
                j--;
            }
            if(i<j)
            {
                char temp=sb.charAt(i);
                sb.setCharAt(i,sb.charAt(j));
                sb.setCharAt(j,temp);
                i++;
                j--;
            }
            
        }
        return sb.toString();
    }
    public boolean isVowel(Character c)
    {
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U');
    }
}
/*
Time Complexity - O(n) where n is length of the string s
Space Complexity - O(n) since StringBuffer is used
*/
