/*
678. Valid Parenthesis String

https://leetcode.com/problems/valid-parenthesis-string/description/

Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    Any right parenthesis ')' must have a corresponding left parenthesis '('.
    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
    An empty string is also valid.

Example 1:

Input: "()"
Output: True

Example 2:

Input: "(*)"
Output: True

Example 3:

Input: "(*))"
Output: True

Note:

    The string size will be in the range [1, 100].

*/
/*
Idea - Take a count, star variable. star tracks the numberr of * in the string. count keeps track of net difference between ( and ).
Initially, increment count on ( and decrement count on ) only if count>0. if count=0, then decrement star if star>0 on receving ) as character.
Doing this will still not resolve the problem, There might still be a case like "*(" . This case fails with the above approach.
So we repeat the same procedure but from reverse i.e., from right to left. Now increment count on seeing ) and decrement on ( if count>0. If count==0, then decrement star if it is >0.
Doing this takes care of the correctness problem.
So we are iterating through the string twice. So the time complexity will be O(2n)=O(n)
*/
class Solution {
    public boolean checkValidString(String s) {
        if(s.equals(""))
            return true;
        else
        {
            //Stack<Character> st=new Stack<>();
            int count=0,star=0;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='(')
                    count++;
                else if(s.charAt(i)==')')
                {
                    if(count>0)
                    {
                        count--;
                    }
                    else
                    {
                        if(star>0)
                            star--;
                        else
                            return false;
                    }
                }
                else if(s.charAt(i)=='*')
                    star++;
            }
            //System.out.println(count+" "+star);
            if(star<count)
                return false;
            count=0;
            star=0;
            for(int i=s.length()-1;i>=0;i--)
            {
                if(s.charAt(i)==')')
                    count++;
                else if(s.charAt(i)=='(')
                {
                    if(count>0)
                    {
                        count--;
                    }
                    else
                    {
                        if(star>0)
                            star--;
                        else
                            return false;
                    }
                }
                else if(s.charAt(i)=='*')
                    star++;
                //System.out.println(count+" "+star);
            }
            return star>=count;
    }
}
}

/*
Time Compexity - O(n)
Space Complexity - O(1)
*/
