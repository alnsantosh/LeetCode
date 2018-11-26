/*
We cannot directly sort the TreeMap based on values. For eg: Look at the following code
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
*/ 
 //Consider the following example code,
 //For more details - https://leetcode.com/problems/sort-characters-by-frequency/description/
 
class Solution {
    public String frequencySort(String s) {
        
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
        }
        
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
        for(Map.Entry<Character,Integer> c:sortedSet)//Iterating through the SortedSet
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
