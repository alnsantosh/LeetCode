/*
415. Add Strings

https://leetcode.com/problems/add-strings/description/

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.

*/
public class Solution {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // write your code here
        StringBuffer sb1=new StringBuffer(num1);
        StringBuffer sb2=new StringBuffer(num2);
        sb1.reverse();
        sb2.reverse();
        int carry=0;
        StringBuffer res=new StringBuffer();
        int temp=0,i=0,j=0;
        while(i<sb1.length() || j<sb2.length())
        {
            temp=carry;
            if(i<sb1.length())
            {
                temp+=Integer.parseInt(String.valueOf(sb1.charAt(i)));
                i++;
            }
            if(j<sb2.length())
            {
                temp+=Integer.parseInt(String.valueOf(sb2.charAt(j)));
                j++;
            }
            carry=0;
            if(temp>=10)
            {
                temp-=10;
                carry+=1;
            }
            //System.out.println(temp+" "+carry);
            res.append(temp+"");
        }
        if(carry==1)
        {
            res.append(carry+"");
        }
        res.reverse();
        return res.toString();
        
    }
}
/*
Time Complexity - O(Max(m,n)) - m,n is length of string num1,num2 respectively
Space Complexity - O(Max(m,n))
*/
