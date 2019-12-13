/*
1221. Split a String in Balanced Strings
Idea: Use stack to deal with the problem. When stack is empty or stack.peek()== the current character of the string, then add the current character to the stack, else pop the top element from the stack. If the stack is empty increment the count. Return count which tells the number of times the stack is empty. (Whenever stack is empty, that means that we have observed equal number of L's and R's)
*/
class Solution {
    public int balancedStringSplit(String s) {
        Stack<Character> st=new Stack<>();
        int count=0;
        st.add(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char c=s.charAt(i);
            if(st.isEmpty() || st.peek()==c ){
                st.push(c);
            }
            else
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                count++;
            }
            
        }
        return count;
    }
}
/*
Time Complexity: O(n) where n=length of string
Space Complexity: O(n)
*/
