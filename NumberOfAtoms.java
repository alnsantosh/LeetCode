/*
726. Number of Atoms

https://leetcode.com/problems/number-of-atoms/description/

Given a chemical formula (given as a string), return the count of each atom.

An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.

1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.

Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.

A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.

Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.

Example 1:

Input: 
formula = "H2O"
Output: "H2O"
Explanation: 
The count of elements are {'H': 2, 'O': 1}.

Example 2:

Input: 
formula = "Mg(OH)2"
Output: "H2MgO2"
Explanation: 
The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.

Example 3:

Input: 
formula = "K4(ON(SO3)2)2"
Output: "K4N2O14S4"
Explanation: 
The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.

Note:
All atom names consist of lowercase letters, except for the first character which is uppercase.
The length of formula will be in the range [1, 1000].
formula will only consist of letters, digits, and round parentheses, and is a valid formula as defined in the problem.
*/
class Solution {
    public String countOfAtoms(String formula) {
        Map<String,Integer> m=stackLogic(formula);
        StringBuilder sb=new StringBuilder();
        for(String str: m.keySet())
        {
            sb.append(str);
            if(m.get(str)>1)
            {
                sb.append(""+m.get(str));
            }
        }
        return sb.toString();
        
    }
    
    public Map<String,Integer> stackLogic(String formula)
    {
        Map<String,Integer> m=new TreeMap<>();
        int n=formula.length();
        int i=0;
        while(i<n)
        {
            if(formula.charAt(i)=='(')
            {
                int count=0;//to count further '('. When count=0 and formula.charAt(i)==')', it means that this ')' is the actial closing bracket we are looking for.
                int start=i+1;
                i++;
                while(!(count==0 && formula.charAt(i)==')'))
                {
                    if(formula.charAt(i)=='(')
                        count++;
                    else if(count>0 && formula.charAt(i)==')')
                    {
                        count--;
                    }
                    i++;
                }
                int end=i;
                i++;//At this point, i is pointing to ). So increment i to find the associated number.
                int digStart=i;//For retreiving number associated with the braces.
                while(i<n && Character.isDigit(formula.charAt(i)))
                {
                    i++;
                }
                int digEnd=i;
                int number=1;
                if(digEnd!=digStart)
                {
                    number=Integer.parseInt(formula.substring(digStart,digEnd));
                }
                    
                Map<String,Integer> temp=stackLogic(formula.substring(start,end));
                for(String s:temp.keySet())
                {
                    m.put(s,m.getOrDefault(s,0)+number*temp.get(s));//update Map using number.
                }
            }
            else
            {   
                
                int start=i;//start points to the capital letter of chemical element
                i++;
                while(i<n && Character.isLowerCase(formula.charAt(i)))
                    i++;
                String str=formula.substring(start,i);//str contains the chemical element
                //System.out.println(str);
                start=i;//start is just to know if there is any number present after the chemical element
                while(i<n && Character.isDigit(formula.charAt(i)))
                {   
                    i++;
                }
                if(start<i)
                {
                    m.put(str,m.getOrDefault(str,0)+Integer.parseInt(formula.substring(start,i)));
                }
                else
                {
                    m.put(str,m.getOrDefault(str,0)+1);
                }
            }
            
        }
        return m;
    }
}
/*
Time Complexity - O(n) - Used dfs whenever ( is found. However every element is traversed only once.
Space Complexity - O(n) worst case, where n is length of string
*/
