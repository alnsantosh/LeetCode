class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Edge cases- Check if the array is empty, check if any of the elements in the array is empty.while comparing the characters of the string check if there are any cases of arrat index out of bounds exception
        if(strs.length==0)
            return "";
        String res=new String();
        int flag=0;
        for(int i=0;i<strs[0].length();i++)
        {
            for(int j=0;j<strs.length;j++)
            {
                if(strs[j].length()==0)
                    return "";
                System.out.println(strs[0].charAt(i));
                if(strs[0].charAt(i)!=strs[j].charAt(i))
                {
                    return res;
                }
                else
                {
                    
                    if(strs[j].length()==i+1) //looking if any of the elements of the string array is completely traversed, in such a scenario, we can exit the code once that iteration is completed.
                    {
                        flag=1;
                    }
                        
                    if(j==strs.length-1)
                    {
                        res=res+String.valueOf(strs[0].charAt(i));
                        if(flag==1)
                        {
                            return res;
                        }
                    }
                }
            }
        }
        return res;
    }
}
