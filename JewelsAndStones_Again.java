/*
771. Jewels and Stones

https://leetcode.com/problems/jewels-and-stones/description/

Idea - Use set to store the charaters in J. Iterate through the elements of S and check if those characters lie in J. Increment the count based on that.Finally return the count.


*/
class Solution {
    public int numJewelsInStones(String J, String S) {
        if(J==null || S==null || J.length()==0 || S.length()==0)
            return 0;
        Set<Character> s=new HashSet<>();
        for(int i=0;i<J.length();i++)
        {
            s.add(J.charAt(i));
        }
        int count=0;
        for(int i=0;i<S.length();i++)
        {
            if(s.contains(S.charAt(i)))
            {
                count++;
            }
        }
        return count;
    }
}
/*
Time Complexity - O(n+m) where n is length of J and m is length of S
Space Complexity - O(1) since the size of set s will be atmost 26+26=52 irrespective the size of the J
*/
