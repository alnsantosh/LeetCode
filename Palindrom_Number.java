class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        else
        {
            int res=0;
            int n=x;
            while(n>0)
            {
                int r=n%10;
                res=res*10+r;
                n=n/10;
            }
            if(x==res)
                return true;
            else
                return false;
            
        }
    }
}
