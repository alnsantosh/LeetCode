/*
1267. Count Servers that Communicate
Idea: One of the approach to the problem is to iterate the grid twice (first rowwise and then columnwise). 
We use a variable called count to store the required result
When iterating rowwise,
Use a variable called star as a flag that would tell if there is any previous 1 in that row. Use c as counter for that row to tell if there are more than 1 server in that row. Variable x,y is to note the coordinates of first server in that row. Logic is as follows: When we see the first server in the row, we set star=true and store the coordinates in x,y. Nexttime, whenever we encounter server in that row, we increment the count and make the value of grid[i][j] to 2 from 1 just to know that it has been already visited. Once the row is fully iterated, we check if c>1. If true, it means that there are atleast two servers in that row. Hence we can increment the count(Note that we have not incremented the count when we find the first server. The reason is that if this server is the only server in the row, then we do not want to add that server to the count. In order to deal with this later, we store the coordinates in x,y) and make grid[x][y]=2 since we need to update the server to visited.
We can apply the above logic to all the rows.
Once we have iterated over all the rows, we use following logic to iterate columnwise,
We basically use the updated grid from rowwise iteration to get the final result. We have the variables star,x,y,c which serves the same purpose as in rowwise iteration. Logic is as follos: When we see the first server (i.e., grid[i][j] can be 1 or 2 because of the updates that we made previously. If grid[i][j]=2, then increment c and update the flag star=true. If grid[i][j]=1, then we store the coordinates of the server in x,y and update star=true.  Next time when we find the server (grid[i][j]=1 only) in the column, we increment the count and make grid[i][j]=2(Making grid[i][j]=2 is not mandatory as we are not going to use this grid later. Doing it just for the consistence wrt to row).Once the column is iterated we check if c>1. We also check in x>=0 and y>=0(We check for these extra conditions here since if we only look for c>1, then there is a high probability that we can have initial server that were already visited during rowwise iteration i.e., the server with grid[i][j]=2. In such a case, value of c will be greater than 1. Hence we also check if x,y>=0. This ensures that we have that the initial visited server in that colums is grid[i][j]=1. In this case we have stores that coordinates of the server for later purpose). If all the conditions are satisfied, then we increment the count and update grid[x][y]=2.

*/
class Solution {
    public int countServers(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            boolean star=false;
            int c=0;
            int x=-2,y=-2;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    if (star){
                        count++;
                        grid[i][j]=2;
                    }
                    else
                    {
                        star=true;
                        x=i;
                        y=j;
                    }
                    c++;
                }
            }
            if(c>1){
                count++;
                grid[x][y]=2;
            }
        }
        //display(grid,count);
        for(int j=0;j<grid[0].length;j++){
            boolean star=false;
            int c=0;
            int x=-2,y=-2;
            for(int i=0;i<grid.length;i++){
                if(grid[i][j]==2){
                    star=true;
                    c++;
                }
                if(grid[i][j]==1){
                    if (star){
                        count++;
                        grid[i][j]=2;
                    }
                    else{
                        star=true;
                        x=i;
                        y=j;
                    }
                    c++;
                }
                
            }
            if(c>1 && x>=0 && y>=0){
                count++;
                grid[x][y]=2;
            }
        }
        //display(grid,count);
        return count;
    }
    
    public void display(int[][] grid,int count){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(count);
    }
}
/*
Time Complexity: O(n*m) where n=number of rows,m=number of columns
Space Complexity: O(1) since we have updates the same grid that was given as input
*/
