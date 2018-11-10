/*
476. Number Complement

https://leetcode.com/problems/number-complement/description/

Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0
*/
/*
Idea - First find the length of bits in binary representation of the number
Invert the bit in number one at a time
*/
class Solution {
    public int findComplement(int num) {
        int x=(int)(Math.log(num)/Math.log(2))+1;//length of bits in num(binary representation)
        for(int i=0;i<x;i++)//logic for reversing bits. In every iteration, I am reversing the ith bit of the num
        {
            num=num^(1<<i);//(1<<i) shifts 1 to the left i times. num^(i-1) gives me the xor of num and i-1. This basically reverses ith bit in the num. We do this for all the bits
        }
        return num;
        
    }
}
/*
Time Complexity - O(log(n)) - log base 2.  Since the for loop runs for log(n) base 2 times, i.e., number of times=noumbe of bits
Space Complexity - O(1)
*/
