/*
509. Fibonacci Number

https://leetcode.com/problems/fibonacci-number/description/

Idea -- Basic fibonacci series logic with recursion


*/
class Solution {
    public int fib(int N) {
        if(N==0 || N==1)
            return N;
        else
        {
            return fib(N-1)+fib(N-2);
        }
    }
}
/*
Time Compelxity - O(2^n)
Space Complexity - O(h) = O(log(n) base 2)
*/
