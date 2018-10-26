/*
345. Reverse Vowels of a String

https://leetcode.com/problems/reverse-vowels-of-a-string/description/

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".
*/
/*
Idea - Use two pointers approach. Start one pointer from beginning and traverse untill you find a vowel. Similarly start another pointer from  end and traverse leftside untill you get a vowel. Now swap the values at the two pointers and continue the same process untill start<end condition is satisfied.
*/
class Solution {
    public String reverseVowels(String s) {
        if(s==null || s.length()==0)
            return s;
        StringBuffer sb=new StringBuffer(s);
        int start=0,end=sb.length()-1;
        Set<Character> c=new HashSet<>();
        c.add('a');
        c.add('e');
        c.add('i');
        c.add('o');
        c.add('u');
        c.add('A');
        c.add('E');
        c.add('I');
        c.add('O');
        c.add('U');
        while(start<end)
        {
            while(!c.contains(sb.charAt(start)) && start<end)//start<end needs to be added here to make sure we stop if it crosses end.Else it will lead to ArrayOutOfBoundsException
            {
                start++;
            }
            //System.out.println(start+" "+end+" "+sb.charAt(start)+" "+sb.charAt(end));
            if(start>=end)//we should break immediate;y if start crosses end
                break;
            while(!c.contains(sb.charAt(end)) && start<end)
            {
                end--;
            }
            if(start>=end)
                break;
            //System.out.println(start+" "+end+" "+sb.charAt(start)+" "+sb.charAt(end));
            Character temp=sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;//Once swapping is done, we increment start and decrement end, else it will lead to infinite loop as the while loop will not execute everytime as it will stay at vowel and the start<end will always be satisfied. Hence it is important step to increment start and decrement end
            end--;
            
        }
        return sb.toString();
        
    }
}
/*
Time Complexity - O(n) - Iterating the string once
Space Complexity  - O(n) - Used StringBuffer
*/
/*
Good Test Case:
".,"
*/
