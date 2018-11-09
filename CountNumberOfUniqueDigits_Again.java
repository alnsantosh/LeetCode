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
Idea - Use premutation concept. We have n blanks and we need to fill them with numbers such that none of the digits are repeated.
So 1st digit can be filled in 9 ways(Since we cannot have 0 as the first digit)
Now we are left with 9 more digits and hence the second digit can be filled with 9 of the remaining digits.
Let n=3
So we need to calculate count for 1 digit, 2 digit and 3 digit numbers
1st digit - 10 unique values, So for 1 digit, count=10
2nd digit - First place with 9 and second place with 9 values = 9*9 = 81
3rd digit - First place with 9, Second place with 9, third place with 8 = 9*9*8 = 648
Total=10+81+648 = 739
*/
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)
            return 1;
        if(n==1)
            return 10;
        // int dp[]=new int[n];
        // dp[0]=10;
        // for(int i=2;i<=n;i++)
        // {
        //     dp[i-1]=dp[i-2]+logic(n);
        // }
        // return dp[dp.length-1];
        int sum=10;
        for(int i=2;i<=n;i++)
        {
            sum+=logic(i);
        }
        return sum;
    }
    public int logic(int n)//Computes count for n-digit number. We just have to sum for all the values from 1 to n to get our desired value
    {
        int sum=1;
        for(int i=0;i<n-1;i++)
        {
            sum*=(9-i);
        }
        sum*=9;
        return sum;
    }
}
/*
Time Complexity - O(n^2) - logic() method is called O(n) times and logic() method has a for loop i.e., O(n) complexity for logic. Total time complexity = O(n^2)
Space Complexity - O(1)
*/
/*
Test case:
Input - 0
Ouyput - 1
*/
