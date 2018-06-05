class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length()>0) //Edge case 1.... Check if the string is empty
        {
            String arr[]=s.split(" ",0);
            System.out.println(arr.length);
            if(arr.length==0) //Edge case 2.... Check if the array length is 0
                return 0;
            return arr[arr.length-1].length();
        }
        else
        {
            return 0;
        }
    }
}
