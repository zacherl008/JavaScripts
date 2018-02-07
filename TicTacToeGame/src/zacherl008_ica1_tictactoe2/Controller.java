package zacherl008_ica1_tictactoe2;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zacherl008
 */
public class Controller {
    
    private Board gameBoard = new Board();
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    int counter = 0;
    
    public Controller(){
        createPlayers();
    }
   
    public void playGame(){
        boolean isOver = false;
        while (!isOver){
            takeTurn();
            if(counter > 4){
                gameBoard.checkWin();
                if(gameBoard.checkWin() == true){
                    h.ps("the game is over and " + currentPlayer.getName()+ " has won!");
                    isOver = true;
                    
                }
            }

            if (counter == 9 && gameBoard.checkWin() == false){
                h.ps("the game is over and no player has won.");
                isOver = true;
            }
        }
    }
    
    private void takeTurn(){
        
        if (counter%2 ==0){
            currentPlayer = playerX;
        }
        else{
            currentPlayer = playerO;
        }
        
        boolean hasMoved = false;
        
        while (!hasMoved){
            hasMoved = gameBoard.placeMove(currentPlayer.makeMove(), currentPlayer.getXO());
            gameBoard.printBoard();
        }
       
        counter++;
    } 
    
    private void createPlayers(){
        Scanner scan = new Scanner(System.in);
        h.ps ("Player 1: Please enter your name: ");
        String name1 = scan.next();
        h.ps ("\n");
        h.ps ("Player 2: Please enter your name: ");
        String name2 = scan.next();
        playerX = new Player(name1, 'X');
        playerO = new Player(name2, 'O');
    }
}
