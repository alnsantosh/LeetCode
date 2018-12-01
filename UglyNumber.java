/*
263. Ugly Number

https://leetcode.com/problems/ugly-number/description/

Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example 1:

Input: 6
Output: true
Explanation: 6 = 2 × 3
Example 2:

Input: 8
Output: true
Explanation: 8 = 2 × 2 × 2
Example 3:

Input: 14
Output: false 
Explanation: 14 is not ugly since it includes another prime factor 7.
Note:

1 is typically treated as an ugly number.
Input is within the 32-bit signed integer range: [−231,  231 − 1].
*/
/*
Idea - Naive approach of dividing the number ny 5,3,2 untill we get 1.
*/
class Solution {
    public boolean isUgly(int num) {
        if(num==0)
            return false;
        while(num%5==0)
        {
            num=num/5;
        }
        while(num%3==0)
        {
            num=num/3;
        }
        while(num%2==0)
        {
            num=num/2;
        }
        return num==1;
    }
}
/*
Time Complexity - O(log(n)) base 2 - worst case assuming that number is only divisible by 2, then say the number is n=2^x, then the number of times n is divided by 2 to get 1=x i.e., log(n)=log(2^x)=x*log(2)=x. In simple words, performing n/2, x times gives us 1.
Space Complexity - O(1)
*/
