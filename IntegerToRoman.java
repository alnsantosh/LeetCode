/*
12. Integer to Roman

https://leetcode.com/problems/integer-to-roman/description/

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: 3
Output: "III"

Example 2:

Input: 4
Output: "IV"

Example 3:

Input: 9
Output: "IX"

Example 4:

Input: 58
Output: "LVIII"
Explanation: C = 100, L = 50, XXX = 30 and III = 3.

Example 5:

Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


*/
class Solution {//Wrote code in a naive way, should use two arrays. 1 array to store values 1000,900,500,400,100,90,50,40,10,9,5,4,1. Another array to store the associated binary format M,CM,D,CD,C,XC,L,XL,X,IX,V,IV,1. Then use one while loop with condition num>1
    public String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        while(num>=1000)
        {
            num-=1000;
            sb.append("M");
        }
        while(num>=900)
        {
            num-=900;
            sb.append("CM");
        }
        while(num>=500)
        {
            num-=500;
            sb.append("D");
        }
        while(num>=400)
        {
            num-=400;
            sb.append("CD");
        }
        while(num>=100)
        {
            num-=100;
            sb.append("C");
        }
        while(num>=90)
        {
            num-=90;
            sb.append("XC");
        }
        while(num>=50)
        {
            num-=50;
            sb.append("L");
        }
        while(num>=40)
        {
            num-=40;
            sb.append("XL");
        }
        while(num>=10)
        {
            num-=10;
            sb.append("X");
        }
        while(num>=9)
        {
            num-=9;
            sb.append("IX");
        }
        while(num>=5)
        {
            num-=5;
            sb.append("V");
        }
        while(num>=4)
        {
            num-=4;
            sb.append("IV");
        }
        while(num>=1)
        {
            num-=1;
            sb.append("I");
        }
        return sb.toString();
    }
}
/*
Time Complexity - O(log(n)) - Time complexity depends on the number of digits in the number which is log(n) where n is the number
Space Complexity - O(n)
*/
