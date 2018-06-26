/*
316. Remove Duplicate Letters

https://leetcode.com/problems/remove-duplicate-letters/description/

Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:

Input: "bcabc"
Output: "abc"

Example 2:

Input: "cbacdcbc"
Output: "acdb"


*/
/*
Idea - Stack can be used to implement this problem. So basic intuition is to push the characters to stack. If the current character of given string is less than the top element in the string, then u pop that element. But there are few constraints here.
Before that, we need
1)visited array to keep an account if we need to visit that character of the string. In case if that string is already present in the stack, then we do not need to have to visit that character again.
2)Count array is to keep track of no. of times a particular character is present in the string. As we traverse the string character by character, we decrement the count of that particular character in the string by 1.

Now that we know the above details, the logic is as follow
1)Initially, for the first character of the string, we push that element into the stack and make visited=true for that character.
2)For the rest of characters,
    1)Check if the stack is not empty
    2)Check if the top element  in the stack > currect character
    3)Check if count for the top element in the stack is >1 i.e, the top element in the stack still exist somewhere in the string
    later on
    If all the above 3 conditions are satisfied, only then we pop from the stack and make the visited=false as we need to visit that later again.
    
Finally, the stack contains the required solution string.
*/
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack=new Stack<>();
        boolean visited[]=new boolean[26];
        int count[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            count[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<s.length();i++)
        {
            count[s.charAt(i)-'a']--;
            if(visited[s.charAt(i)-'a'])
               continue;
            while(!stack.empty() && stack.peek()>s.charAt(i) && count[stack.peek()-'a']>0)
            {
                visited[stack.pop()-'a']=false;
            }
            stack.push(s.charAt(i));
            visited[s.charAt(i)-'a']=true;
            
        }
        StringBuffer sb=new StringBuffer();
        for(Character c:stack)
        {
            sb.append(c);
        }
        return sb.toString();
    }
}
/*
Time Complexity - O(m*n) = O(26*n)=O(n)
m=no of elements that can be present in stack
n=no of elements(characters) in string
Space Complexity - 
*/
