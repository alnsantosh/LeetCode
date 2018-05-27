class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> m=new HashMap<>();
        m.put('(',')');
        m.put('[',']');
        m.put('{','}');
        List<Character> l=new ArrayList<>();
        
        if(s.length()==0)
            return true;
        
        
        for(int i=0;i<s.length();i++)
        {
            if(m.containsKey(s.charAt(i)))
            {
                l.add(s.charAt(i));
            }
            else //if it is coming to else part, then it means that current character is either ],} or ) . 
            {
                if(l.size()==0) //So this if is true onlu if the string s begins with one of the above three characters which is not a valid parenthesis.
                {
                    return false;
                }
                
                if(m.get(l.get(l.size()-1))==s.charAt(i))
                {
                    l.remove(l.size()-1);
                }
                else
                    return false;
            }
            
        }
        if(l.size()==0) //After the iteration, if the list is empty, it means that valid parenthesis was present in the striong, hence true is returned
            return true;
        else
            return false;
        
    }
}
