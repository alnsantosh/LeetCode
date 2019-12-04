/*
1029. Two City Scheduling
Idea: Sort the costs using custom comparator. Sorting is based on the following idea
Consider [a0,a1],[b0,b1], Here a0-a1,b0-b1 gives us the additional cost that we need to send the flying person to city A over city B. We sort the array based on this difference. Hence (a0-a1)-(b0-b1) value is used in the comparator.
Once the costs array is sorted, for the first half elements, we add costs[i][0] i.e., we send the person flying to city A and for the second half elemnts we add costs[i][1] i.e., we send the second half of the persons flying to city B.
*/
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,new Comparator<int[]>(){
            public int compare(int a[],int b[]){
                return (a[0]-a[1])-(b[0]-b[1]);
            }
        });
        // display(costs);
        int cost=0;
        for(int i=0;i<costs.length/2;i++){
            cost+=costs[i][0]+costs[costs.length-i-1][1];
        }
        return cost;
    }
    public void display(int[][] costs){
        for(int i=0;i<costs.length;i++){
            for(int j=0;j<costs[0].length;j++){
                System.out.print(costs[i][j]+" ");
            }
            System.out.println();
        }
    }
}
/*
Time Complexity: O(nlogn) since sorts array is sorted
Space Complexity: O(1)
*/
