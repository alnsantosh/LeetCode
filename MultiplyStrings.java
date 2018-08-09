/*
43. Multiply Strings

https://leetcode.com/problems/multiply-strings/description/

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"

Note:

    The length of both num1 and num2 is < 110.
    Both num1 and num2 contain only digits 0-9.
    Both num1 and num2 do not contain any leading zero, except the number 0 itself.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.


*/
/*
Idea - Start from right to left, perform multiplication on every pair of digits, and add them together.

 `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]` 

*/
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0") || num1.length()==0 || num2.length()==0)
            return "0";
        int[] temp=new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--)
        {
            int ch=num1.charAt(i)-'0';
            for(int j=num2.length()-1;j>=0;j--)
            {
                int prod=ch*(num2.charAt(j)-'0');
                int x=i+j;
                int y=i+j+1;
                temp[y]+=prod%10;
                int carry=0;
                if(temp[y]>=10)
                {
                    carry=temp[y]/10;
                    temp[y]=temp[y]%10;
                }
                temp[x]+=prod/10+carry;
                //System.out.println(x+" "+y+" "+temp[x]+" "+temp[y]+" "+carry+" "+prod);
            }
        }
        StringBuffer sb=new StringBuffer();
        int ind=0;
        while(temp[ind]==0)//This while is to trim 0's in the beginning of the result
        {
            ind++;
        }
        for(int i=ind;i<temp.length;i++)
        {
            sb.append(temp[i]+"");
        }
        return sb.toString();
    }
}
/*
Time Complexity - O(m*n) when m and n are lengths of strings num1,num2
Space Complexity - O(m+n) - for the temp array. Also the sb size is also equal to O(m+n)
*/
