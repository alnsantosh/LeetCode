
/*

721. Next Sparse Number

Description

A number is Sparse if there are no two adjacent 1s in its binary representation. Given a number n, find the smallest Sparse number which greater than or equal to n.
eg. 5 (binary representation: 101) is sparse, but 6 (binary representation: 110) is not sparse.
Have you met this question in a real interview?  
Example

Given n = 6, return 8
Next Sparse Number is 8

Given n = 4, return 4
Next Sparse Number is 4

Given n = 38, return 40
Next Sparse Number is 40

Given n = 44, return 64
Next Sparse Number is 64

*/
/*
Idea - Traverse right to left of the binary converted string, if u get ....011.... pattern, replace that with ....10000(all zeroes). basically replace 11 followd by anything with all zeroes. 
*/
public class Solution {
    /**
     * @param x: a number
     * @return: return the next sparse number behind x
     */
    public int nextSparseNum(int x) {
        // write your code here
        String binary=Integer.toBinaryString(x);
        char b[]=binary.toCharArray();
        boolean first=false;//If we reach to the first bit when traversing from right to left and if 11 is found at b[0] and b[1], then add 1 to res followed by all zeroes.
        int end=binary.length()-1;
        String res;
        //System.out.println(binary);
        for(int i=binary.length()-1;i>0;i--)
        {
            
            
            if(b[i]=='1' && b[i-1]=='1')
            {
                if(i-2>=0 && b[i-2]=='0')
                {
                    System.out.println(i-2);
                    b[i-2]='1';
                    for(int j=i-1;j<=end;j++)
                    {
                        b[j]='0';
                    }
                    end=i-2;
                    //i=end;
                }
                else
                {
                    first=true;
                }
                // for(int k=0;k<b.length;k++)
                // {
                //     System.out.print(b[k]+" ");
                // }
                // System.out.println();
            }
            
        }
        if(!first)
        {
            res=new String(b);
            
        }
        else
        {
            StringBuilder sb=new StringBuilder("1");
            for(int i=0;i<binary.length();i++)
            {
                sb.append("0");
            }
            res=sb.toString();
        }
        //System.out.println(res);
        return Integer.parseInt(res,2);
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(log n)
*/
