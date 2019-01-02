/*
914. X of a Kind in a Deck of Cards

https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/description/

Idea - Find the count of each unique number associated with each unique card in deck.
Now, find the gcd value and check if the gcd is >=2. In that case return true, else return false.

Inspired from
https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/solution/
*/
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<deck.length;i++)
        {
            m.put(deck[i],m.getOrDefault(deck[i],0)+1);
        }
        //System.out.println(m.size());
        int g=-1;
        for(int key:m.keySet())
        {
            if(g==-1)
            {
                g=m.get(key);
            }
            else
            {
                g=gcd(g,m.get(key));
            }
        }
        
        return g>=2;
    }
    
    public int gcd(int a,int b)
    {
        if(a==0)
            return b;
        else
            return gcd(b%a,a);
    }
}
/*
Time Complexity - O(nlog(m)) where n is no. of unique cards in the deck i.e., size of the map and m=Count of each unique card found (gcd complexity is log(m))
Space Complexity - O(1) since a deck has 53 cards. Hence the map will have atmost 52 keys in it making the space complexity constant.
*/
