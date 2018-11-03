/*
165. Compare Version Numbers

https://leetcode.com/problems/compare-version-numbers/description/

Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Example 1:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Example 2:

Input: version1 = "1.0.1", version2 = "1"
Output: 1
Example 3:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1
*/
/*
Idea - Basic comparison between two strings, need to consider all the cases while writing the code
*/
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int i=0,j=0;
        while(true)
        {
            //System.out.println(i+" "+j+" "+v1[i]+" "+v2[j]);
            if(Integer.parseInt(v1[i])>Integer.parseInt(v2[j]))
            {
                return 1;
            }
            else if (Integer.parseInt(v1[i])<Integer.parseInt(v2[j]))
            {
                return -1;
            }
                i++;
                j++;
                if(i>=v1.length)//checking if i pointer is past v1.length. If that is the case, then we traverse all the remaining element in the v2 array and check if all the elements are 0. If all the elements are 0, we return 0 as version1=version2, else we return -1 as in this case version2>version1
                {
                    for(;j<v2.length;j++)
                    {
                        if(Integer.parseInt(v2[j])!=0)
                            return -1;
                    }
                    return 0;
                }
                    
                if(j>=v2.length)//checking if j pointer is past v2.length. If that is the case, then we traverse all the remaining element in the v1 array and check if all the elements are 0. If all the elements are 0, we return 0 as version1=version2, else we return 1 as in this case version1>version2
                {
                    for(;i<v1.length;i++)
                    {
                        if(Integer.parseInt(v1[i])!=0)
                            return 1;
                    }
                    return 0;
                }
        }
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n+m) where n is length of version1 and m is length of version2
*/
