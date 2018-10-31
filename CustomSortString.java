/*
791. Custom Sort String

https://leetcode.com/problems/custom-sort-string/description/

S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input: 
S = "cba"
T = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 

Note:

S has length at most 26, and no character is repeated in S.
T has length at most 200.
S and T consist of lowercase letters only.
*/
/*
Idea - Use 26 length integer array where each index corresponds to an alphabet
Store the count of the occurence of a character of String T in this array.
Now traverse through S array and based on count in the array created in the previous step, create an output string. While doing this, make those corresponding counts to 0 in the array.
Now traverse through the array, and add the corresponding characters to the output string for which you see positive count in array.
*/
class Solution {
    public String customSortString(String S, String T) {
        int[] t=new int[26];
        for(int i=0;i<T.length();i++)
        {
            t[T.charAt(i)-'a']+=1;
        }
        // for(int i=0;i<t.length;i++)
        // {
        //     System.out.print(t[i]+" ");
        // }
        StringBuffer res=new StringBuffer();
        for(int i=0;i<S.length();i++)
        {
            for(int j=0;j<t[S.charAt(i)-'a'];j++)
            {
                //res+=S.charAt(i);
                res.append(S.charAt(i));
            }
            t[S.charAt(i)-'a']=0;
        }
        // System.out.println();
        // for(int i=0;i<t.length;i++)
        // {
        //     System.out.print(t[i]+" ");
        // }
        for(int i=0;i<t.length;i++)
        {
            for(int j=0;j<t[i];j++)
            {
                //System.out.println(i+" "+t[i])
                //res+=(char)('a'+i);
                res.append((char)('a'+i));
            }
        }
        return res.toString();
    }
}
/*
Time Complexity - O(max(n,m)) - where n is length of S and m is length of T
Space Complexity - O(m)
*/
