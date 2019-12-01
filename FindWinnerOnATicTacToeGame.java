/*
1275. Find Winner on a Tic Tac Toe Game
Idea: Create a grid[3][3] and fill that with X and O based on the given input moves[][]. won() method checks whether any of the player has won. It checks for horizontal,vertical or diagonal win. isEmpty() checks if the grid has any empty cell. If none of the player won and if the grid does not have empty cell, then the game is in Draw state. Else, the game is in the Pending state. 
*/
class Solution {
    public String grid[][]=new String[3][3];
    public String tictactoe(int[][] moves) {
        int chance =1;
        for(int i=0;i<moves.length;i++){
            if(chance==1){
                grid[moves[i][0]][moves[i][1]]="X";
                chance=0;
            }
            else{
                grid[moves[i][0]][moves[i][1]]="O";
                chance=1;
            }
        }
        //display();
        if(won("X")){
            return "A";
        }
        else if(won("O")){
            return "B";
        }
        else if (!isEmpty()){
            return "Draw";
        }
        else{
            return "Pending";
        }
        
    }
    public boolean won(String s){
        for(int i=0;i<grid.length;i++){//Horizontal check
            int count=0;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=null && grid[i][j].equals(s)){
                    count++;
                }
                if(count>=3){
                    return true;
                }
            }
        }
        for(int j=0;j<grid[0].length;j++){//Vertical check
            int count=0;
            for(int i=0;i<grid.length;i++){
                if(grid[i][j]!=null && grid[i][j].equals(s)){
                    count++;
                }
                if(count==3){
                    return true;
                }
            }
        }
        int count=0;
        for(int i=0;i<grid.length;i++){//Diagonal check
            if(grid[i][i]!=null && grid[i][i].equals(s)){
                count++;
            }
        }
        if(count==3){
            return true;
        }
        count=0;
        for(int i=0;i<grid.length;i++){//Reverse diagonal Check
            if(grid[i][grid.length-i-1]!=null && grid[i][grid.length-i-1].equals(s)){
                count++;
            }
        }
        if(count==3){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==null || grid[i][j].equals("")){
                    return true; 
                }
            }
        }
        return false;
    }
    public void display(){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
/*
Time Complexity: O(1) since we have a grid of dimension 3*3
Space Complexity: O(1) since we have a grid of dimension 3*3
*/
