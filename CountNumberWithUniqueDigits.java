/*
357. Count Numbers with Unique Digits

https://leetcode.com/problems/count-numbers-with-unique-digits/description/

Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:

Input: 2
Output: 91 
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, 
             excluding 11,22,33,44,55,66,77,88,99
*/
/*
Idea - Backtracking approach. Basically generate 10-ary tree with all the possible combinations and increment count for every valid case.
*/
class Solution {
    int count=1;
    public int countNumbersWithUniqueDigits(int n) {
        boolean[] vis=new boolean[10];
        logic(n,vis,0);
        return count;
    }
    void logic(int n,boolean[] vis,int pos)
    {
        if(pos==n)
            return;
        //int count=1;
        for(int i=(pos==0)?1:0;i<10;i++)//The first digit in the number should not be zero, In order to make sure that run for 1(inclusive) to 10(exclusive) in case pos=0(i.e., first digit of the number). For rest of the cases, run for loop from 0(inclusive) to 10(exclusive).
        {
            //System.out.println(i+" "+vis[i]+" "+pos+" "+count);
            if(!vis[i])
            {
                vis[i]=true;
                logic(n,vis,pos+1);
                vis[i]=false;
                count++;
            }
        }
    }
}
/*
Time Complexity - O(10^n) - Backtracking approach
Space Complexity - O(n^2) - Since vis array is passed in logic() method. Everytime whenever logic method is called, new vis array is created. Since it is a dfs approach, the recursive stack size will be atmost n., i.e., n logic() functions will be present in the recusrive stack and for each logic() method, there is a vis[] array of length n. So the space complexity becomes n*n=n^2
*/
