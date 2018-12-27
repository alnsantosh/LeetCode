/*
942. DI String Match

https://leetcode.com/problems/di-string-match/description/

Idea - Always keep small and large variables to track the smallest and largest element used in the given range.
Now if we get I, assign the small value and increment small. Similarly, if we het D, assign large to res[i] and decrement large. At the end assign res[res.length-1] with either small or large. That will give us the desired result.

Inspired from:
https://leetcode.com/problems/di-string-match/solution/

*/
class Solution {
    public int[] diStringMatch(String S) {
        int small=0,large=S.length();
        int[] res=new int[S.length()+1];
        for(int i=0;i<S.length();i++)
        {
            if(S.charAt(i)=='I')
            {
                res[i]=small;
                small++;
            }
            else
            {
                res[i]=large;
                large--;
            }
        }
        res[res.length-1]=small;//we can assign small or large to res[res.length-1] as both are same
        return res;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n) if we take res[] array as extra space
*/
