/*
500. Keyboard Row

https://leetcode.com/problems/keyboard-row/description/

Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 
Example:

Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
 
Note:

You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.
*/
/*
Idea - Use sets to store the letters in each row of the keyboard. Now iterate through all the strings in words array and check if all the characters belong to any one of the created sets
*/
class Solution {
    public String[] findWords(String[] words) {
        Set<Character> s1=new HashSet<>();
        for(Character c:"qwertyuiop".toCharArray())
        {
            s1.add(c);
        }
        Set<Character> s2=new HashSet<>();
        for(Character c:"asdfghjkl".toCharArray())
        {
            s2.add(c);
        }
        Set<Character> s3=new HashSet<>();
        for(Character c:"zxcvbnm".toCharArray())
        {
            s3.add(c);
        }
        //String[] res=new String[words.length];
        List<String> res=new ArrayList<>();
        //int index=0;
        for(String str:words)
        {
            //str=str.toLowerCase();
            Set<Character> temp=new HashSet<>();
            for(int i=0;i<str.length();i++)
            {
                temp.add(str.toLowerCase().charAt(i));
            }
            //System.out.println(str);
            if(s1.containsAll(temp) || s2.containsAll(temp) || s3.containsAll(temp))
            {
                res.add(str);
            }
            //System.out.println(s1.containsAll(temp) || s2.containsAll(temp) || s3.containsAll(temp));
        }
        return res.toArray(new String[res.size()]);
        
    }
}
/*
Time Complexity - O(m*n) - m is length of words array. O(n) is length of each string in array 
Space Complexity - O(m*n) - Used List
*/
/*
Another approach to do the problem(More efficient)
Idea - Take a map to store all the alphabets with the value =row the letter belongs in the keyboard
eg: a=1,b=2,c=2,d=1,e=0,f=1,g=1,h=1,i=0
Now for each string in the words array,
Store the value in the map corresponding to the first character in the array, Now check if the remaining characters have the same value as the first character in the string.
This way, 
Time Complexity - O(m*n) - where n is the length of the words array (O(1) complexity to check if every character in the map)
However we are looking through mao only once unlike the approach implemented above wherin I used 3 sets and was checking in each set for every string
*/
