/*
537. Complex Number Multiplication

https://leetcode.com/problems/complex-number-multiplication/description/

Idea - For given strings which are of the form a+bi, seperate a, b from that. Then multiplication is a simple constant operation.
Let the final answer be x+yi
Here, x= a1[0]*b1[0]-a1[1]*b1[1]
y=a1[0]*b1[1]+a1[1]*b1[0]
*/
class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] a1=a.replace("i","").split("\\+");
        String[] b1=b.replace("i","").split("\\+");
        //System.out.println(a1[0]+" "+a1[1]);
        //System.out.println(b1[0]+" "+b1[1]);
        int x=0;
        return (Integer.parseInt(a1[0])*Integer.parseInt(b1[0])-Integer.parseInt(a1[1])*Integer.parseInt(b1[1]))+"+"+(Integer.parseInt(a1[0])*Integer.parseInt(b1[1])+Integer.parseInt(a1[1])*Integer.parseInt(b1[0]))+"i";
    }
}
/*
Time Complexity - O(1) Since it is given that the given two strings are of the form a+ib where both a and b belongs to [-100,100]. Hence we can assume the length of given string as constants. So the split can be considered as constant operation in our case
Space Complexity - O(1) Since it is given that the given two strings are of the form a+ib where both a and b belongs to [-100,100]. So the size of  a1 and b1 is constant.
*/
