/*
58. Length of Last Word

https://leetcode.com/problems/length-of-last-word/description/

Idea -- Split the sentence into words array and simply return the last word length in the array.


*/
class Solution {
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0)//Base case
            return 0;
        String[] array=s.split(" ");
        if(array.length==0)//Edge case. This happenss when s has all white spaces in it
            return 0;
        return array[array.length-1].length();
    }
}
/*
Time Complexity - O(n) where n is length of s
Space Complexity - O(n) since array is used
*/
