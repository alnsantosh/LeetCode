/*
868. Binary Gap

https://leetcode.com/problems/binary-gap/description/

Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.

If there aren't two consecutive 1's, return 0.

 

Example 1:

Input: 22
Output: 2
Explanation: 
22 in binary is 0b10110.
In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
The first consecutive pair of 1's have distance 2.
The second consecutive pair of 1's have distance 1.
The answer is the largest of these two distances, which is 2.
Example 2:

Input: 5
Output: 2
Explanation: 
5 in binary is 0b101.
Example 3:

Input: 6
Output: 1
Explanation: 
6 in binary is 0b110.
Example 4:

Input: 8
Output: 0
Explanation: 
8 in binary is 0b1000.
There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.
 

Note:

1 <= N <= 10^9
*/
/*
Idea - Iterate through all the 32 bits and perform bitwise and operation with 1. For each iteration, if the result is 0, then the ith bit in N is 0, else if result!=0, ith bit in N is 1.
Store the prev value of N and initalize gap=0.
Update the gap and prev accordingly whenever 1 is observed in N while iterating over all the bits.
*/
class Solution {
    public int binaryGap(int N) {
        int gap=0;
        int prev=-1;
        for(int i=0;i<32;i++)
        {
            if((N&(1<<i))!=0)
            {
                if(prev>=0)
                {
                    gap=Math.max(gap,i-prev);
                    //System.out.println(gap+" "+(i-prev));
                }
                prev=i;
                //System.out.println(i+" "+prev+" "+gap);
            }
        }
        return gap;
    }
}
/*
Time Complexity  - O(1) - Since int size is 32. We loop over 32 times.
Space Complexity - O(1)
*/
