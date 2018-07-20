/*
402. Remove K Digits

https://leetcode.com/problems/remove-k-digits/description/

Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:

    The length of num is less than 10002 and will be ≥ k.
    The given num does not contain any leading zero.

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.


*/
/*
Idea - 
*/
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s=new Stack<>();
        if(num.length()==k)
            return "0";
        for(int i=0;i<num.length();i++)
        {
            //System.out.println(i+" "+num.charAt(i)+" "+k);
            if(k==0)
            {
                s.push(num.charAt(i));
            }
            if(s.empty())
            {
                s.push(num.charAt(i));
            }
            else
            {
                
                if(!s.empty() && k>0)
                {
                    // if(s.peek()<=num.charAt(i))
                    // {
                    //     s.push(num.charAt(i));
                    // }
                    // else
                    // {
                    //     s.pop();
                    //     s.push(num.charAt(i));
                    //     k--;
                    // }
                    while(!s.empty() && s.peek()>num.charAt(i) && k>0)//If top>current char, then keep popping untill the condition fails and then push this current element to stack. First test case was failing because of this being unproper
                    {
                        s.pop();
                        k--;
                    }
                    s.push(num.charAt(i));
                }
                
                
            }
        }
        while(k>0)//Important corner case. If k is not empty after the for loop, then pop from stack untill k becomes zero. Second test case was failing because of this test case
        {
            s.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!s.empty())//pop elements from stack and put them in string
        {
            sb.append(String.valueOf(s.pop()));
        }
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}
/*
Edge cases - 

"1234567890"
9

"111"
1
*/
/*
Time Complexity - O(n^2) - since for loop and stack
Space Complexity - O(n)
*/
