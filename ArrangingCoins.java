/*
441. Arranging Coins

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.

Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.

*/

class Solution {
    public int arrangeCoins(int n) { //If we take low,mid,high as int, then it will fail for the case when input is very large i.e., 32 bit. In the other cases it will pass.
        //return (int)(-1+Math.sqrt(1+8*(long)n))/2;  // This line alone will pass the solution
        long low=1;
        long high=n;
        long mid=low+(high-low)/2;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            long temp=(mid*(mid+1))/2;
            //System.out.println("High: "+high+" Low: "+low+" Mid: "+mid+" Temp: "+temp);
            if(temp==n)
            {
                return (int)mid;
            }
            else if(temp>n)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return (int)low-1; //index x which needs to be returned if the x*(x+1)/2!=n i.e, we look for the next lower number from the current low.
        
    }
}

/*
Time Complexity - O(log(n))
*/
