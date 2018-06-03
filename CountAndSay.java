class Solution {
    public String countAndSay(int n) {
        String res=String.valueOf(1);
        for(int i=0;i<n-1;i++)
        {
            System.out.println(res);
            res=generate(res);
            
        }
        return res;
    }
    public String generate(String n)
    {
        String sb=n;
        
        int count=0;
        String res="";
        for(int i=0;i<sb.length();i++)
        {
            count++;
            if(i+1==sb.length())
            {
                res+=String.valueOf(count)+sb.charAt(i);
                break;
            }
            if(sb.charAt(i)!=sb.charAt(i+1))
            {
                res=res+count+sb.charAt(i);
                count=0;
            }
           
        }
        
        
        
        
        return res;
    }
}
