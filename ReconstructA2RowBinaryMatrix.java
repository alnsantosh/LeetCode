/*
1253. Reconstruct a 2-Row Binary Matrix
Idea: First fill the columns with [1,1] when colsum[i]=2 and in the rest of the cases fill 0's. When colsum[i]==1, fill the upper row with 1 and lower with 0 until the total number of 1's in the upper row is equal to upper. Then fill the lower row with 1 and upper row with 0 for the remaining values in colsum whenever colsum[i]==1. 
*/
class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<Integer>());
        res.add(new ArrayList<Integer>());
        int countu=upper;
        int countl=lower;
        // System.out.println(countu+" "+countl);
        for(int i=0;i<colsum.length;i++){
            // List<Integer> l=new ArrayList<>();
            if(colsum[i]==2){
                res.get(0).add(1);
                res.get(1).add(1);
                countu-=1;
                countl-=1;
            }
            else
            {
                res.get(0).add(0);
                res.get(1).add(0);
            }
            // res.add(l);
        }
        // System.out.println(countu+" "+countl);
        for(int i=0;i<colsum.length;i++){
            if(colsum[i]==1)
            {
                if(countu>0){
                    res.get(0).set(i,1);//making top row value to 1
                    // res.get(1).add(0);
                    countu--;
                }
                else{
                    if(countl>0){
                        // res.get(1).add(0);
                        res.get(1).set(i,1);//making bottom row to 1
                        
                        countl--;
                    }
                    else
                    {
                        return new ArrayList<>();
                    }
                }
            }
        }
        // System.out.println(countu+" "+countl);
        if(countu==0 && countl==0)
        {
            return res;
        }
        else
        {
            
            return new ArrayList<>();
            
        }
    }
}
/*
Time Complexity: O(n) where n=length of colsum
Space Complexity: O(1)
*/
