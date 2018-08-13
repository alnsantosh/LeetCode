/*
22. Generate Parentheses

https://leetcode.com/problems/generate-parentheses/description/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

*/

class Solution {
    String p="()";
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n==0)
            return res;
        logic(n,0,0,0,new StringBuffer());
        return res;
    }
    public void logic(int n,int pos,int left,int right, StringBuffer sb)//left- count of left parenthesis
    {
        //System.out.println(n+" "+pos+" "+left+" "+sb);
        if(pos>2*n || left>n || right>n || right>left)//edge cases, right>left is to check for valid parenthesis
            return;
        if(pos==2*n && left==n && right==n)//valid parenthesis condition
        {
            res.add(sb.toString());
            return;
        }
        for(int i=0;i<p.length();i++)
        {
            // sb.append(p.charAt(i));
            // if(p.charAt(i)=='(')
            //     left++;
            // if(p.charAt(i)==')')
            //     right++;
            // logic(n,pos+1,left,right,sb);
            // sb.deleteCharAt(sb.length()-1);
            // if(p.charAt(i)=='(')
            //     left--;
            // if(p.charAt(i)==')')
            //     right--;
            
            sb.append(p.charAt(i));//Include the char
            if(p.charAt(i)=='(')//Further recursive call
                logic(n,pos+1,left+1,right,sb);
            else
                logic(n,pos+1,left,right+1,sb);
            sb.deleteCharAt(sb.length()-1);//Exclude that char
        }
    }
}
/*
Time Complexity - O(2^(2*n)) = O(4^n)
Space Complexity - O(n)
*/
