/*
696. Count Binary Substrings

https://leetcode.com/problems/count-binary-substrings/description/

Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

Example 1:
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

Notice that some of these substrings repeat and are counted the number of times they occur.

Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
Example 2:
Input: "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
Note:

s.length will be between 1 and 50,000.
s will only consist of "0" or "1" characters.

*/
/*
Idea - Inspired from 
https://leetcode.com/problems/count-binary-substrings/solution/
*/
class Solution {
    public int countBinarySubstrings(String s) {
        int left=0,right=0;//store the length of consecutive 1's or 0's. We need to track two such blocks of 1's and 0'2. So taking two variables
        int i=1;
        int sum=0;//final result
        left++;//by default weincrement by 1 as there will be atleat 1 or 0 initially
        while(i<s.length() && s.charAt(i)==s.charAt(i-1))//If at i=0, it was 1, we increment left till we get 1. Hence left=length of 1's
        {
            left++;
            i++;
        }
        //System.out.println(i+" "+left+" "+right);
        while(i<s.length())
        {            
            right++;//Similarly we increment right as there will be one occurenece of other bit,in our assumption case 0
            i++;//we need to increment i to compare the new values, else the while loop in next line will never be executed
            while(i<s.length() && s.charAt(i)==s.charAt(i-1))//length of right=number of consecutive 0's as per our assumption
            {
                right++;
                i++;
            }
            //System.out.println(i+" "+left+" "+right);
            sum+=Math.min(left,right);//This gives us the number of substring we get with number of 1's and 0's same
            left=right;
            right=0;
        }
        return sum;
    }
}
/*
Time Complexity - O(n) - n is length of string
Space Complexity - O(1)
*/
