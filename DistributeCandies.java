/*
575. Distribute Candies

https://leetcode.com/problems/distribute-candies/description/

Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
Example 1:
Input: candies = [1,1,2,2,3,3]
Output: 3
Explanation:
There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too. 
The sister has three different kinds of candies. 
Example 2:
Input: candies = [1,1,2,3]
Output: 2
Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1]. 
The sister has two different kinds of candies, the brother has only one kind of candies. 
Note:

The length of the given array is in range [2, 10,000], and will be even.
The number in given array is in range [-100,000, 100,000].
*/
/*
Idea - Store all the elements in the set with key as the value in the array and value as the number of occurences of the key in the array
The size of the map will give us the unique number of candies. We can actually use a set too as we do not need the counts of each candy type.
Now we check if (total candies)/2>map size. If true, then it means that we have more than enough candies such that both of them get all the type of candies. However if false, then we return candies.length/2 as that is the maximum types of candies sister can have.
*/
class Solution {
    public int distributeCandies(int[] candies) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<candies.length;i++)
        {
            m.put(candies[i],m.getOrDefault(candies[i],0)+1);
        }
        return (candies.length/2)>=m.size()?m.size():(int)(candies.length/2);
        
    }
}
/*
Time Complexity - O(n) - Iterated through all the elements in the array
Space Complexity - O(n) - Since used a hashmap
*/
/*
We can solve this question is O(1) space but in that case we will have to sort the given array so that we know the all the similar type of candies are together are now we can get the unique type of cadies count in O(n). However the sorting will be O(nlog(n))
*/
