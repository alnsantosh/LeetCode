/*
367. Valid Perfect Square

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True

Example 2:

Input: 14
Returns: False

Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.

*/

class Solution {
    public boolean isPerfectSquare(int num) {
        
        long low =0;
        long high=num;
        long mid = high-(high-low)/2;
        long temp;
        while(low<=high)
        {
            System.out.println("mid: "+mid+"low: "+low+"high: "+high);
            //mid=high-(high-low)/2;
            mid=low+(high-low)/2;
            temp=mid*mid;
            if(temp==num)
                return true;
            else if(temp>num)
                high=mid-1;
            else
                low=mid+1;
        }
        return false;
	}
}

/*
Time Complexity - O(log(n))
*/
