/*
1051. Height Checker
Idea: Make clone of the heights array. Sort the heights array. Now compare each element of the height sarray with the associated element of the clone. Increment the count whenever there is a mismatch in the values.
*/
class Solution {
    public int heightChecker(int[] heights) {
        int[] heights2=heights.clone();
        Arrays.sort(heights);
        int count=0;
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=heights2[i]){
                count++;
            }
        }
        return count;
    }
}
/*
Time Complexity: O(nlogn) where n=lengt of the array. nlogn since array is sorted
Space Complexity: O(n) since we have cloned the array
*/
