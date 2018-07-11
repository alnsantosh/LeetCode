/*
76. Minimum Window Substring

https://leetcode.com/problems/minimum-window-substring/description/

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Note:

    If there is no such window in S that covers all characters in T, return the empty string "".
    If there is such window, you are guaranteed that there will always be only one unique minimum window in S.


*/
/*
Reference - 
https://medium.com/leetcode-patterns/leetcode-pattern-2-sliding-windows-for-strings-e19af105316b
*/

class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> track=new HashMap<>();//create a map to store the counts of all the elements in t
        for(int i=0;i<t.length();i++)
        {
            char tmp=t.charAt(i);
            if(track.containsKey(tmp))
            {
                track.put(tmp,track.get(tmp)+1);
            }
            else
            {
                track.put(tmp,1);
            }
        }
        // for(int i=0;i<t.length();i++)
        // {
        //     System.out.println(t.charAt(i)+" : "+track.get(t.charAt(i)));
        // }
        
        int start=0,end=0; //start,end is for the window size regulation
        int count=track.size();//count variable is used to check if a valid substring in s is found which contains all the elements in t
        int minLen=Integer.MAX_VALUE;//to compare the length of substring which has all elements in t, and update the res if length is minimum
        String res=new String();
        
        while(end<s.length())//end is iterated till it reaches end
        {
            char c=s.charAt(end);
            if(track.containsKey(c))//it s contains c, then decrement the counter in the map. whenever an element in map reaches zero, decrement the count by 1. So when count becomes zero, it means all elements in map are empty i.e., a valid substring is found.
            {
                track.put(c,track.get(c)-1);
                if(track.get(c)==0)
                    count--;
            }
            end++;
            
            while(count==0)//whenever a valid substring i.e., substring which has all the elements in the t is found, we increment "start" untill we find an element  of t is found such that its corresponding value in map>0. In such a case, we increment count so that it comes out of loop.
            {
                //System.out.println("start: "+start+" end: "+end+" minLen: "+minLen+" end-start+1: "+(end-start+1));
                if(minLen>end-start+1)//check if the length is less than minLen
                {
                    minLen=end-start+1;
                    res=s.substring(start,end);
                    //System.out.println(res);
                    
                }
                char tmp=s.charAt(start);
                if(track.containsKey(tmp))//
                {
                    track.put(tmp,track.get(tmp)+1);
                    if(track.get(tmp)>0)
                        count++;
                }
                start++;
            }
            
            
        }
        //System.out.println(track.get('A'));
        return res;
    }
}

/*
Time Complexity - O(n)
Space Complexity - O(n) in worst case.
*/
