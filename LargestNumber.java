/*
179. Largest Number

https://leetcode.com/problems/largest-number/description/

Idea -- Write the custom sort for sorting the array. Instead of sorting the array in the descending order, sort the array based on (s2+s1).compareTo(s1+s2). This makes sure that we get the largest number when we append all the string in the array.

Inspired from
https://leetcode.com/problems/largest-number/solution/
*/
class Solution {
    public String largestNumber(int[] nums) {
        String[] s=new String[nums.length];
        StringBuffer result=new StringBuffer();
        for(int i=0;i<nums.length;i++)
        {
            s[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(s,new Comparator<String>(){
            public int compare(String s1,String s2)
            {
                return (s2+s1).compareTo(s1+s2);
            }
        });
        if(s[0].equals("0"))
            return "0";
        for(int i=0;i<s.length;i++)
        {
            result.append(s[i]);
        }
        return result.toString();
    }
}
/*
Time Complexity - O(nlog(n)) since we are sorting the array
Space Complexity - O(n) since we are using additional array which stores the string format of the given array
*/
