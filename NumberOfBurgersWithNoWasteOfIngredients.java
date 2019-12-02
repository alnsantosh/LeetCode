/*
1276. Number of Burgers with No Waste of Ingredients
Idea: Let [x,y] be the solution i.e., x=number of jumbo burgers, y=number of small burgers
It is evident that,
4x+2y=tomatoSlices
x+y=cheeseSlices
Rewriting first equation
2x+2*(x+y)=tomatoSlices
2x+2*cheeseSlices=tomatoSlices
x=(tomatoSlices-2*cheeseSlices)/2
y=cheeseSlices-x
*/
class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int x,y;
        List<Integer> res=new ArrayList<>();
        if(tomatoSlices%2!=0){
            return res;
        }
        x=(tomatoSlices-(2*cheeseSlices))/2;
        y=cheeseSlices-x;
        if(x>=0 && y>=0){
            res.add(x);
            res.add(y);
        }
        return res;
    }
}
/*
Time Complexity: O(1)
Space Complexity:O(1)
*/
