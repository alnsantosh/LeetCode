/*
7. Reverse Integer

https://leetcode.com/problems/reverse-integer/description/

Idea - Use long variable to store the reversed value
long is used as the reverse value may caise integer overflow. So we check that condition and return 0 in case we face that issue
Logic is to take the last element in x and store that in result after multiplying result by 10. Then do x=x/10
Return the integer typecasted value


*/
class Solution {
    public int reverse(int x) {
        long result=0;
        while(x!=0)
        {
            int r=x%10;
            result=result*10+r;
            if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE)
                return 0;
            x=x/10;
        }
        return (int)result;
    }
}
/*
Time Complexity - O(log(x) base 10)
Space Complexity - O(1)
*/
