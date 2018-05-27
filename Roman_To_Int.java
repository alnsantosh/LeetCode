class Solution {
    public int romanToInt(String s) {
        //Traverse from left to right. If the current roman digit value is greater than the previous value, then subtract the previous value from the sum. If the current roman value is smaller than the previous one, then add the previous value to the sum. At the end of iteration, we will get the desired output.
        Map<Character,Integer> m=new HashMap<>();
        m.put('M',1000);
        m.put('D',500);
        m.put('C',100);
        m.put('L',50);
        m.put('X',10);
        m.put('V',5);
        m.put('I',1);
        int sum=0;
        int prev=-1;
        for(int i=0;i<s.length();i++)
        {
            if(prev==-1)
            {
                sum=sum+m.get(s.charAt(i));
                prev=m.get(s.charAt(i));
            }
            else
            {
                if(prev>=m.get(s.charAt(i)))
                {
                    prev=m.get(s.charAt(i));
                    sum+=prev;
                }
                else
                {
                    prev=m.get(s.charAt(i));
                    sum+=prev;
                    sum-=2*m.get(s.charAt(i-1));
                }
            }
        }
        return sum;
        
    }
}
