class Solution {
    public int reverse(int x) {
        int neg=0;
        if(x<0)
        {
            x=-1*x;
            neg=1;
        }
        String str=String.valueOf(x);
        
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        try
        {
            System.out.println(Integer.parseInt(String.valueOf(sb))>(2147483647));
        //if(Integer.parseInt(String.valueOf(sb))>(2147483647) || Integer.parseInt(String.valueOf(sb))<=-2147483648)
          //  return 0;
        if(neg==0)
            return Integer.parseInt(String.valueOf(sb));
        else
            return Integer.parseInt(String.valueOf(sb))*-1;
        }
        catch(Exception e)
        {
            return 0;
        }
        
        
    }
}
