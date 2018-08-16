/*
79. Word Search

https://leetcode.com/problems/word-search/description/

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

*/
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || board[0].length==0)
            return false;
        if(word==null || word.length()==0)
            return true;
        boolean[][] vis=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(logic(board,new StringBuffer(word),i,j,0,vis))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean logic(char[][] board,StringBuffer word,int i,int j,int pos,boolean[][] vis)
    {
        if(pos==word.length())
        {
            return true;
        }
        //System.out.println(i+" "+j+" "+pos);
        if(i<0 || i>=board.length || j<0 || j>=board[i].length || pos>=word.length() || board[i][j]!=word.charAt(pos) || vis[i][j] )
            return false;
        vis[i][j]=true;
        boolean x= logic(board,word,i,j-1,pos+1,vis) || logic(board,word,i,j+1,pos+1,vis) || logic(board,word,i-1,j,pos+1,vis) || logic(board,word,i+1,j,pos+1,vis);
        vis[i][j]=false;
        return x;
    }
}
/*
Time Complexity - O((n*m)^2) - n*m for the two for loops, another m*n for recursive function. COnsider a worst case, when we have to traverse all the elements of the matrix(when the given string is not present)

a a a
a b a
a a a

Say the string is aaaaaaaaa

For m*n times, all the m*n are traversed recursively. Therefore O(m*n*m*n) = O((m*n)^2)
Space Complexity - O(m*n)
*/
