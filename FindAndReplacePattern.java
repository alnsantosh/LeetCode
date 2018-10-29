/*
890. Find and Replace Pattern

https://leetcode.com/problems/find-and-replace-pattern/description/

You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern. 

You may return the answer in any order.

 

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.
 

Note:

1 <= words.length <= 50
1 <= pattern.length = words[i].length <= 20
*/
/*
Idea - If say, the first letter of the pattern is "a", and the first letter of the word is "x", then in the permutation, "a" must map to "x".

We can write this bijection using two maps: a forward map \text{m1}m1 and a backwards map \text{m2}m2.

\text{m1} : \text{&quot;a&quot;} \rightarrow \text{&quot;x&quot;}
m1:"a"→"x"

\text{m2} : \text{&quot;x&quot;} \rightarrow \text{&quot;a&quot;}
m2:"x"→"a"

Then, if there is a contradiction later, we can catch it via one of the two maps. For example, if the (word, pattern) is ("aa", "xy"), we will catch the mistake in m1 (namely m1("a")="x"="y"). Similarly, with (word, pattern) = ("ab", "xx"), we will catch the mistake in m2.
*/
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res=new ArrayList<>();
        for(int i=0;i<words.length;i++)
        {
            if(logic(words[i],pattern))
                res.add(words[i]);
        }
        return res;
    }
    public static boolean logic(String word,String pattern)//Create two maps, one for word and one for pattern.
    {
        Map<Character,Character> w=new HashMap<>();
        Map<Character,Character> p=new HashMap<>();
        for(int i=0;i<word.length();i++)//In every iteration, add character at ith index into either map only if that character is not already present in map. Now at the end of iteration,check that for map w key1->value1 and for map p key2->value2, make sure that key1=value2 and key2=value1, else return false.
        {
            if(!w.containsKey(word.charAt(i)))
                w.put(word.charAt(i),pattern.charAt(i));
            if(!p.containsKey(pattern.charAt(i)))
                p.put(pattern.charAt(i),word.charAt(i));
            if(w.get(word.charAt(i))!=pattern.charAt(i) || p.get(pattern.charAt(i))!=word.charAt(i))
                return false;
        }
        return true;
        
    }
}
/*
Time Complexity - O(n*m) where n is size of words array. m is length of string in each index of array
Space Complexity - O(n*m) - n*m would be the space used by res
*/
