/*
763. Partition Labels

Beats 37%

https://leetcode.com/problems/partition-labels/description/

 A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

Note:

    S will have length in range [1, 500].
    S will consist of lowercase letters ('a' to 'z') only.

*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res=new ArrayList<>();
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<S.length();i++)
        {
            if(m.containsKey(S.charAt(i)))
                m.put(S.charAt(i),m.get(S.charAt(i))+1);
            else
                m.put(S.charAt(i),1);
        }
        //System.out.println(m.get(S.charAt(1)));
        int count=0;
        Set<Character> temp=new HashSet<>();
        for(int i=0;i<S.length();i++)
        {
            
            m.put(S.charAt(i),m.get(S.charAt(i))-1);
            temp.add(S.charAt(i));
            count++;
            if(m.get(S.charAt(i))==0)
            {
                temp.remove(S.charAt(i));
                if(temp.isEmpty())
                {
                    res.add(count);
                    count=0;
                }
            }
        }
        
        return res;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n) since using HashMap and HashSet - Worst case if all the characters in the string are unique, in that case
the size of Map and Set would be O(n)
*/
