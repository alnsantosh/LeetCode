/*
989. Add to Array-Form of Integer

https://leetcode.com/problems/add-to-array-form-of-integer/description/

Idea - Basic addition of two numbers columnwise

Inspired from:
https://leetcode.com/problems/add-to-array-form-of-integer/solution/
*/
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<A.length;i++)//loading the values of A into result
        {
            result.add(A[i]);
        }
        int num=K;
        for(int i=result.size()-1;i>=0;i--)//adding K to last value in result. Keeping last digit there are passing the rest value to the previous element in the list result
        {
            int temp=result.get(i)+num;
            int r=temp%10;
            result.set(i,r);
            num=temp/10;
        }
        while(num>0)//If the num is not 0, it means that there is some carry left out. This number can be greater than 1 digit, so we keep adding the units place of the number to result's zero'th position and perform num=num/10
        {
            int temp=num%10;
            result.add(0,temp);
            num=num/10;
        }
        return result;//result contains the final desired answer
    }
}
/*
Time Complexity - O(n+log(K)) where n is lnegth of Array A, log(K) is the number of digits in K. Here log(K) means log(K) with base 10
Space Complexity - O(n+log(K))
*/
