/*
20. Valid Parentheses

https://leetcode.com/problems/valid-parentheses/description/

Idea - Use stack and make the updates accordingly


*/
class Solution {
    public boolean isValid(String s) {
        if(s.length()==0)
            return true;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(stack.isEmpty())//if stack is empty, simply add the character into the stack
            {
                stack.push(s.charAt(i));
            }
            else
            {
                char c=s.charAt(i);
                if(c=='(' || c=='{' || c=='[')//if we get (,{,[ then we simply push that into the stack
                    stack.push(c);
                else if(c==')' && stack.peek()=='(') //if the current character is ) and the top element inn stack is (, we simply pop the top element from the stack
                    stack.pop();
                else if(c=='}' && stack.peek()=='{')//if the current character is } and the top element inn stack is {, we simply pop the top element from the stack
                    stack.pop();
                else if(c==']' && stack.peek()=='[')//if the current character is ] and the top element inn stack is [, we simply pop the top element from the stack
                    stack.pop();
                else //if(c==')' || c=='}' || c==']') //This case means that we have either ),} or ] but the top element in the stack is not the one which we counter of that bracket. Here either we can push this element into the stack or directly return that element into the stack
                    //stack.push(c);
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n) since stack is used. Atmost all the characters in the string can be stored in the stack
*/
