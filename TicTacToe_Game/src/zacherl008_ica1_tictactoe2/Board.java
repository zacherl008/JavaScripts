package zacherl008_ica1_tictactoe2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zacherl008
 */
public class Board {
    private char [] [] grid;
    
    public Board (){
        initBoard();
        printBoard();
    }
    
    public boolean placeMove(int[] rc, char player){
        if (grid[rc[0]][rc[1]] == ' '){
            grid[rc[0]][rc[1]] = player;
            return true;
        }
        else{
            h.ps("You can't move there... the space is taken.");
            return false;
        }
    }
            
    public boolean checkWin(){
        for (int i = 0; i <grid.length; i++){
            if (grid[i][0] == grid [i][1] && grid[i][0] == grid[i][2] && grid[i][0] != ' '){
                return true;
            }
            else if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != ' '){
                return true;
            }
        }    
        if (grid[0][2] == grid [1][1] && grid[1][1] == grid[2][0] && grid[1][1] != ' '){
            return true;
        }
        else if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != ' '){
            return true;
        }
        else{
            return false;
        }
    }
    
    private void initBoard(){
        grid = new char [3][3];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                grid [i][j] = ' ';
            }
        }
    }
    public void printBoard(){
        for(int i = 0; i < grid.length; i++){
            String str = " ";
            for(int j = 0; j < grid.length; j++){
                if (j < 2){
                    str += grid [i][j] + "   |   ";
                }else{
                    str += grid [i][j];
                }
            }
            h.ps(str);
            if (i<2){
                h.ps("------------------");
            }
        }
    }
}
