/*
693. Binary Number with Alternating Bits

https://leetcode.com/problems/binary-number-with-alternating-bits/description/

Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

Example 1:
Input: 5
Output: True
Explanation:
The binary representation of 5 is: 101
Example 2:
Input: 7
Output: False
Explanation:
The binary representation of 7 is: 111.
Example 3:
Input: 11
Output: False
Explanation:
The binary representation of 11 is: 1011.
Example 4:
Input: 10
Output: True
Explanation:
The binary representation of 10 is: 1010.
*/
/*
Idea - Convert integer to binary string
*/
class Solution {
    public boolean hasAlternatingBits(int n) {
        // boolean lsb=n&1;
        // int mod =s.length()%2;
        // System.out.println(lsb);
        // int len=n.length()-1;
        // while(i=len;i>=0;i--)
        // {
        //     if(i%lenn&1 == lsb)
        // }
        // return false;
        
        String s=Integer.toBinaryString(n);
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
                return false;
        }
        return true;
    }
}
/*
Time Complexity - O(1) - since s.length() will be <=32. Hence worst case O(32)= O(1)
Space Complexity - O(1) - Since the size of the string will be atmost 32
*/
