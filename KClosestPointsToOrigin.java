/*
973. K Closest Points to Origin

https://leetcode.com/problems/k-closest-points-to-origin/description/

Idea -- Use map m to store the distance from the origin(Since we need to calculate the distance from the origin, we can simply check the squared sum of the x and y coordinated given) and the index referencing the points as value
Now sort the map based on key. Corresponding value will give the index of the coordinate in the points array


*/
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int result[][]=new int[K][points[0].length];
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<points.length;i++)
        {
            m.put((points[i][0]*points[i][0])+(points[i][1]*points[i][1]),i);
        }
        Map<Integer,Integer> sorted;//stores the m sorted by keys
        sorted=new TreeMap<>(new Comparator<Integer>(){//Comparator is used for custom sorting
            public int compare(Integer i1,Integer i2)
            {
                if(i1>i2)
                    return 1;
                else if(i1<i2)
                    return -1;
                else
                    return 0;
            }
        });
        sorted.putAll(m);
        int index=0;
        for(int key:sorted.keySet())//Iterating through the top K entries in sorted map and storing those corresponding coordinated in result array.
        {
            if(K==0)
                break;
            result[index++]=points[sorted.get(key)];
            K--;
            //System.out.println(key+" "+sorted.get(key));
        }
        return result;
    }
}
/*
Time Complexity - O(nlog(n)) since we are soring the map m
Space Complexity - O(n) since map is used
*/
