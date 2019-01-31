/*
344. Reverse String

https://leetcode.com/problems/reverse-string/description/

Idea -- Swap the first and last value in the array, second and second last, third and third last, fourth and fourth last and so on.


*/
class Solution {
    public void reverseString(char[] s) {
        if(s==null || s.length==0)
            return;
        int n=s.length;
        for(int i=0;i<n/2;i++)
        {
            char temp=s[i];
            s[i]=s[n-1-i];
            s[n-1-i]=temp;
        }
    }
}
/*
Time Complexity - O(n/2) = O(n) where n is length of s array
Space Complexity - O(1)
*/
