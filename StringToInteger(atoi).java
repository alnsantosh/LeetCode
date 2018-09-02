/*
8. String to Integer (atoi)

https://leetcode.com/problems/string-to-integer-atoi/description/

Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.
*/

class Solution {
    public int myAtoi(String str) {
        if(str.length()==0 || str==null)//if string is empty or null
            return 0;
        int ind=0;//stores the current index which we are accessing
        for(int i=0;i<str.length();i++)//this loop is to trim the whitespaces at the beginnig of the string
        {
            ind=i;
            if(str.charAt(i)!=' ')
            {
                break;
            }
        }//At this point, the ind points to either length-1 or to some non-whitespace character
        if(str.charAt(ind)==' ')//If this case is true,it means that ind is pointing to the str.length()-1. Means that all the characters are whitespaces, so we return 0
            return 0;
        boolean minus=false;// tells if the given number is +ve or -ve
        if(str.charAt(ind)=='-')
        {
            minus=true;
            ind++;
        }
        else if(str.charAt(ind)=='+')
        {
            ind++;
        }//If + or - is not present, then by default it is treated as positive
        if(ind>=str.length())//If the + or - sign is the last character of the string, then we have to return 0
            return 0;
        if(!Character.isDigit(str.charAt(ind)))//After + or -, if the next immediate character is non-digit, we return 0
            return 0;
        int low=ind,high=ind;//low,high to track the indices of the number in the string
        for(int i=ind;i<str.length();i++)//logic to store the indices of number
        {
            if(Character.isDigit(str.charAt(i)))
            {
                high++;
            }
            else
            {
                break;
            }
        }
        double num=Double.parseDouble(str.substring(low,high));//we store that number in double as it might cross the integer bounds.
        if(minus)//make it negative if required
        {
            num=-num;
        }
        //System.out.println(num);
        if(num>Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }
        else if(num<Integer.MIN_VALUE)
        {
            return Integer.MIN_VALUE;
        }
        return (int)num;
        
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
