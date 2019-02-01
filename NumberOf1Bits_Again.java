/*
191. Number of 1 Bits

https://leetcode.com/problems/number-of-1-bits/description/

Idea -- Initalize mask=1 and perform bitwise and operation with n. This will tell if LSB is 1. Keep doing left shift on mask for 32 times and perform an doperation with n and see if the value is not zero. This will tell if that bit in n is 1 ot not. Keep incrementing the bits variable whenevr 1 is encoutered and return the bits value at the end.

Inspired from
https://leetcode.com/problems/number-of-1-bits/solution/
*/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bits =0;
        int mask=1;
        for(int i=0;i<32;i++)
        {
            if((n&mask)!=0)
                bits++;
            mask=mask<<1;
        }
        return bits;
    }
}
/*
Time Complexity - O(1) since iterated for 32 times which is a constant number
Space Complexity - O(1)
*/
