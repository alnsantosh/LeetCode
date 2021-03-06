/*
 Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:

Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"

Note:

    letters has a length in range [2, 10000].
    letters consists of lowercase letters, and contains at least 2 unique letters.
    target is a lowercase letter.

*/

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
       char res=letters[0];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<letters.length;i++)
        {
            int temp=letters[i]-target;
            //System.out.print(temp+" ");
            if(temp<0)
            {
                temp=26-target-letters[i];
            }
            System.out.print(temp+" ");
            if(temp<min && temp>0) //temp>0 is in if condition as we need next Greatest Letter
            {
                min=temp;
                res=letters[i];
            }
        }
        return res;
        
    }
}

/*
Time Complexity - O(n)
*/
