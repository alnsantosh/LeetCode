/*
607. Two Sum III - Data structure design

Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.
Example

add(1); add(3); add(5);
find(4) // return true
find(7) // return false


*/
public class TwoSum {
    /*
     * @param number: An integer
     * @return: nothing
     */
    
    Map<Integer,Integer> m=new HashMap<>();
    public void add(int number) {//O(1)
        // write your code here
        if(m.containsKey(number))
        {
            m.put(number,m.get(number)+1);
        }
        else
            m.put(number,1);
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {//O(n)
        // write your code here
        for(int key:m.keySet())
        {
            int target=value-key;
            if(m.containsKey(target) && key!=target)
                return true;
            else if(key==target && m.get(target)>1)
                return true;
        }
        return false;
    }
}
