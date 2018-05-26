class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        else
        {
            String str=String.valueOf(x);
            StringBuffer sb=new StringBuffer(str);
            sb.reverse();
            return str.equals(String.valueOf(sb));
            
            
        }
    }
}
