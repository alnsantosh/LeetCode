/*
848. Shifting Letters

https://leetcode.com/problems/shifting-letters/description/

We have a string S of lowercase letters, and an integer array shifts.

Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a'). 

For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.

Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.

Return the final string after all such shifts to S are applied.

Example 1:

Input: S = "abc", shifts = [3,5,9]
Output: "rpl"
Explanation: 
We start with "abc".
After shifting the first 1 letters of S by 3, we have "dbc".
After shifting the first 2 letters of S by 5, we have "igc".
After shifting the first 3 letters of S by 9, we have "rpl", the answer.
Note:

1 <= S.length = shifts.length <= 20000
0 <= shifts[i] <= 10 ^ 9
*/
/*
Idea - store the sum of shift array in a variable sum. No compute character shifts.
*/
class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        int sum=0;
        for(int i=0;i<shifts.length;i++)
            sum=(sum+shifts[i])%26;
        //sum=sum%26;
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<shifts.length;i++)
        {
            int index=(S.charAt(i)-'a')+sum;
            index=index%26;
            //sum=(sum-shifts[i])%26;
            //System.out.println(sum);
            //System.out.println(shifts[i]);
            //System.out.println(sum-shifts[i]);
            //System.out.println(sum-shifts[i]%26);
            //System.out.println(26-((sum-shifts[i])%26));
            //System.out.println(Math.floorMod(sum - shifts[i], 26));
            //break;
            sum = Math.floorMod(sum - shifts[i], 26);//floorMod returns floor modulus of the integer arguments passed to it
            //sum = (sum-shifts[i])>0?(sum-shifts[i])%26:26-((sum-shifts[i])%26);
            System.out.println(sum);
            sb.append((char)(('a'+(index%26))));
        }
        return sb.toString();
    }
}
/*
Time Complexity - O(n) - Iterating the array of size n
Space Complexity - O(n) - StringBuffer size
*/
