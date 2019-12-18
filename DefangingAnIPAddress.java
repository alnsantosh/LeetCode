/*
1108. Defanging an IP Address
Idea: Straighforward approach. Replace . with [.]
*/
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<address.length();i++)
        {
            if(address.charAt(i)=='.')
            {
                sb.append('[');
                sb.append('.');
                sb.append(']');
            }
            else
            {
                sb.append(address.charAt(i));
            }
        }
        return new String(sb);
    }
}
/*
Time Complexity: O(n) where n =length of address
Space Complexity: O(n) since used stringBuilder. Used StringBuilder since it is mutable whereas String is immutable. If we have used String, then every append operation in the above code would have costed O(n) and thus the complexity would have become O(n*n)
*/
