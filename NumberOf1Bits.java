/*
191. Number of 1 Bits

https://leetcode.com/problems/number-of-1-bits/description/

Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Example 1:

Input: 11
Output: 3
Explanation: Integer 11 has binary representation 00000000000000000000000000001011 
Example 2:

Input: 128
Output: 1
Explanation: Integer 128 has binary representation 00000000000000000000000010000000
*/
/*
Idea - Inspired from the following link
https://leetcode.com/problems/number-of-1-bits/solution/
*/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // double d=(double)n;//This logic is giving TLE, naive approach to convert integer to binary and then count the 1's
        // int count=0;
        // while(d!=0)
        // {
        //     //System.out.println(d);
        //     if(d%2==1)
        //         count++;
        //     d=Math.floor(d/2);
        // }
        // return count;
        
        
        int count=0;
        while(n!=0)//Here you should not use n>0 because we are asked to assume n as unsigned int, but for large numbers for which most significant number(MSB) is 1, it would be considered as negative as n is of type int. Hence we have to take the condition n!=0
        {
            count++;
            n=n&(n-1);
        }
        return count;
    }
}
/*
Time Complexity - O(1)
Space Complexity - O(1)
*/
