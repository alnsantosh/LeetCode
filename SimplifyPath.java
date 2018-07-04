/*
71. Simplify Path

https://leetcode.com/problems/simplify-path/description/

Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

Corner Cases:

    Did you consider the case where path = "/../"?
    In this case, you should return "/".
    Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
    In this case, you should ignore redundant slashes and return "/home/foo".


*/
class Solution {
    public String simplifyPath(String path) {
        String temp[]=path.split("/");
        StringBuilder res=new StringBuilder();
        int index=0;
        //System.out.println(temp.length);
        for(int i=0;i<temp.length;i++)
        {
            
            if(temp[i].equals(".") || temp[i].equals(""))//base case
                continue;
            else if(temp[i].equals(".."))
            {
                //System.out.println("Index: "+index+"Len: "+res.length());
                res.replace(index,res.length(),"");
                if(res.toString().equals(""))//This case happens when res becomes empty, in that case we need to append /
                    res.append("/");
                index=res.toString().lastIndexOf('/');
                //System.out.println("Index: "+index);
            }
            else//Case wherein we have something to insert into the res
            {
                index=res.length();
                if(res.length()!=0 && res.charAt(res.length()-1)=='/')//making sure that if / is present at the end of res, then we do not add another /
                    res.append(temp[i]);
                else
                    res.append("/").append(temp[i]);
            }
            //System.out.println(temp[i]);
        }
        if(res.toString().equals(""))//if the resultant relative path is the same directory, then res will be "", so we need to append "/" to res.
            res.append("/");
        return res.toString();
    }
}

/*
Time Complexity - O(n)
Space Complexity - O(n)
*/
