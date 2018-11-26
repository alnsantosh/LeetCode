/*
451. Sort Characters By Frequency

https://leetcode.com/problems/sort-characters-by-frequency/description/

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/
/*
Notes - We cannot directly sort the TreeMap based on values. For eg: Look at the following code
    Map<Character,Integer> m;
    m=new TreeMap<>(new Comparator<Character>(){
    public int compare(Character c1, Character c2)
    {
        if(m.get(c1)>m.get(c2)) --------------This statement is not valid. The code will throw an error saying that map may not have beenn initialized.
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
});

In order to sort the TreeMap based on values, we need to use SortedMap, we can use the following approach

SortedSet<Map.Entry<String, Double>> sortedset = new TreeSet<Map.Entry<String, Double>>(
            new Comparator<Map.Entry<String, Double>>() {
                @Override
                public int compare(Map.Entry<String, Double> e1,
                        Map.Entry<String, Double> e2) {
                    return e1.getValue().compareTo(e2.getValue());
                }
            });

  sortedset.addAll(myMap.entrySet());
 -----------------------------------------------------------------------------------------
Idea - Use SortedSet to store the sorted list of characters. Now iterate through the elements of the set and append them to the string appropriately.

*/
class Solution {
    //Map<Character,Integer> m;
    public String frequencySort(String s) {
        // m=new TreeMap<>(new Comparator<Character>(){
        //     public int compare(Character c1, Character c2)
        //     {
        //         if(c1>c2)
        //         {
        //             return 1;
        //         }
        //         else
        //         {
        //             return -1;
        //         }
        //     }
        // });
        
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
        }
        // for(Character c:m.keySet())
        // {
        //     System.out.println(c+": "+m.get(c));
        // }
        
        SortedSet<Map.Entry<Character,Integer>> sortedSet=new TreeSet<>(
            new Comparator<Map.Entry<Character,Integer>>(){
                public int compare(Map.Entry<Character,Integer> e1, Map.Entry<Character,Integer> e2)
                {
                    //return e2.getValue().compareTo(e1.getValue()); - If we use the default compareTo() function , then the keys with same value are deleted. For ex: Consider "tree", t-1,r-1,e-2 . Here the sortedSet is only storing e,r in the set instead of storing all the three characters. To overcome this, I have used the following code
                    
                    if(e2.getValue()>=e1.getValue())
                        return 1;
                    // else if(e2.getValue()==e1.getValue()) - Somehow, the sorted Map is removing the elements which have same value if we return 0.
                    //     return 0;
                    else
                        return -1;
                }
            });
        sortedSet.addAll(m.entrySet());
        StringBuffer sb=new StringBuffer();
        for(Map.Entry<Character,Integer> c:sortedSet)
        {
            int count=c.getValue();
            for(int i=0;i<count;i++)
            {
                sb.append(c.getKey());
            }
            //System.out.println(c.getKey()+": "+c.getValue());
        }
        return sb.toString();
    }
}
/*
Time Complexity - O(n) - Since iterating through all the elements in the string
Space Complexity - O(n)  - Used HashMap and SortedSet
*/
