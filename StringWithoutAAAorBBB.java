/*
984. String Without AAA or BBB

https://leetcode.com/problems/string-without-aaa-or-bbb/description/

Idea -- Following cases needs to be considered
A=0
B=0
A=B
A-B>=2
B-A>=2
Finally A-B=1 or B-A=1 which is covered by the else case in the below logic
*/
class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuffer sb=new StringBuffer();
        if(A==0)
        {
            for(int i=0;i<B;i++)
            {
                sb.append("b");
            }
            return sb.toString();
        }
        else if(B==0)
        {
            for(int i=0;i<A;i++)
            {
                sb.append("a");
            }
            return sb.toString();
        }
        else if(A==B)
        {
            for(int i=0;i<A;i++)
                sb.append("ab");
            return sb.toString();
        }
        else if(A-B>=2)
        {
            sb.append("aab").append(strWithout3a3b(A-2,B-1));
            return sb.toString();
        }
        else if(B-A>=2)
        {
            sb.append("bba").append(strWithout3a3b(A-1,B-2));
            return sb.toString();
        }
        else
        {
            sb.append("ab").append(strWithout3a3b(A-1,B-1));
            return sb.toString();
        }
        
    }
}
/*
Time Complexity - O(A+B)
Space Complexity - O(A+B)
*/
