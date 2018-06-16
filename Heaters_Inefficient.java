//This solution gives TLE .... the logic is correct but not efficient.

/*

475. Heaters

Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

Note:

    Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
    Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
    As long as a house is in the heaters' warm radius range, it can be warmed.
    All the heaters follow your radius standard and the warm radius will the same.

Example 1:

Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.

Example 2:

Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.


*/

class Solution {//Let m=no. of houses , n=no of heaters
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters); //O(nlog(n))
        int max=Integer.MIN_VALUE;
        for(int i=0;i<houses.length;i++)
        {
            int value=binary_search(houses[i],heaters);//returns the distance between the house and the heater which is closest to that house
            if(value>max)
                max=value;
        }
        return max;
        
        
        
    }
    int binary_search(int house,int[] heater)
    {
        if(heater.length==0)
            return 0;
        int low=0;
        int high=heater.length-1;
        int mid=low+(high-low)/2;
        if(house<heater[low]) //if house is before first heater
            return (heater[low]-house);
        if(house>heater[high])
            return (house-heater[high]); //if house is after last heater
        while(low<=high)//binary search when house is between first heater and last heater
        {
            mid=low+(high-low)/2;
            System.out.println("House:"+house+" Low: "+low+" High: "+high+" Mid: "+mid);
            if(heater[mid]==house)
                return 0;
            else if(house<heater[mid])
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        int dist=Integer.MAX_VALUE;
        int target=house;
        //System.out.println("*********************************************************");
        //System.out.println("House:"+house+" Low: "+low+" High: "+high+" Mid: "+mid);
        

        if(target<heater[low])//calculating the closest distance between the heater and the house.
        {

            if(target-heater[low-1]>heater[low]-target)
                dist=heater[low]-target;
            else
                dist=target-heater[low-1];
        }
        else
        {
            if(target-heater[low]>heater[low+1]-target)
                dist=heater[low+1]-target;
            else
                dist=target-heater[low];   
        }
        return dist;
    }
}

/*
We are itearting through all the houses and for each house, we are using binary search to find the closest heater to that house.
Therefor, Time Complexity= O(mlog(n))
*/
