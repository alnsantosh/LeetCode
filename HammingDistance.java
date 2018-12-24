/*
461. Hamming Distance

https://leetcode.com/problems/hamming-distance/description/

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
*/
/*
Idea - XOR value is 1 i.e., x^y=1 iff x!=y. So we can calculate the hamming distance between two integers by calculating XOR between them. The hamming distance is equal to number of 1's in the result obtained after performing XOR of given two integers.
*/
class Solution {
    public int hammingDistance(int x, int y) {
        int n=x^y;//Calculating XOR of x and y
        String bits=Integer.toBinaryString(n);//Converting Integer to bits
        int count=0;
        for(int i=0;i<bits.length();i++)
        {
            if(bits.charAt(i)=='1')
                count++;
        }
        return count;
    }
}
/*
Time Complexity - O(max of no. of bits in x and y)
Space Complexity - O(max of no. of bits in x and y)
*/
/**/
