/*
278. First Bad Version

https://leetcode.com/problems/first-bad-version/description/

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 
*/
/*
Idea - Basic Binary Search
*/
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return logic(0,n);
    }
    public int logic(int low,int high)
    {
        if(low>high)
            return -1;
        int mid=low+(high-low)/2;
        //System.out.println(low+" "+high+" "+mid);
        if(isBadVersion(mid) && !isBadVersion(mid-1))
            return mid;
        else if(!isBadVersion(mid))
        {
            return logic(mid+1,high);
        }
        else
        {
            return logic(low,mid-1);
        }
    }
}
/*
Time Complexity - O(log(n))
Space Complexity - O(1)
*/
