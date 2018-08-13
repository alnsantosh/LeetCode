/*
17. Letter Combinations of a Phone Number

https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.

*/
class Solution {
    String[] str={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return res;
        logic(digits,0,new StringBuffer());
        return res;
    }
    public void logic(String digits,int pos,StringBuffer sb)
    {
        if(pos==digits.length())
        {
            res.add(sb.toString());
            return;
        }
        String s=str[Integer.parseInt(String.valueOf(digits.charAt(pos)))];
        for(int i=0;i<s.length();i++)
        {
            sb.append(s.charAt(i));
            logic(digits,pos+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
}
/*
Time Complexity - O(n)
Space Complexity - O(n) where n is length of digits
*/
