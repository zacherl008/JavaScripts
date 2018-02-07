/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zacherl008_reptiles;

import java.util.Scanner;

/**
 *
 * @author kzacherl
 */
public class Game {
    boolean endGame = false;
    boolean breakLoop = false;
    int i = 0;
    AbstractReptile[] myReptiles;
    
    public Game(){
        myReptiles = new AbstractReptile[11];
        myReptiles[0] = new Snake();
        myReptiles[1] = new Alligator();
        myReptiles[2] = new Crocodile();
        myReptiles[3] = new Turtle();
        myReptiles[4] = new Tortoise();
        myReptiles[5] = new Gecko();
        myReptiles[6] = new Chameleon();
        myReptiles[7] = new Caiman();
        myReptiles[8] = new Monitor();
        myReptiles[9] = new Iguana();
        myReptiles[10] = new LeglessLizard();
        shuffle();
    }
    
    public void playGame(){    
        System.out.println("Welcome to Guess The Reptile!"); 
        while(!endGame){
            while(!breakLoop){
            System.out.println("Here is your first clue: " + myReptiles[i].FamilyClue());
            System.out.println("Would you like to make a guess? Input yes or no.");
            Scanner scan = new Scanner(System.in);
            String response = scan.next();
            if(response.equals("yes")){
                if(guessName() == true){
                    break;
                }
            }
            System.out.println("Here is your second clue: " + myReptiles[i].SubsetClue());
            System.out.println("Would you like to make a guess? Input yes or no.");
            response = scan.next();
            if(response.equals("yes")){
                if(guessName() == true){
                    break;
                }
            } 
            System.out.println("Here is your final clue: " + myReptiles[i].clue());
            System.out.println("Make your final guess!");
            if (guessName() == false){
                System.out.println("You lose! The reptile was a " + myReptiles[i].getName());
            }
            break;
            }
        if (i == 10){
            shuffle();
            i = 0;
        }    
        System.out.println("Would you like to play again? Input yes or no.");
        Scanner scan = new Scanner(System.in);
        String response = scan.next();
        if (response.equals("yes")){
            breakLoop = false;
            i++;
        }
        else{
            System.out.println("Thank you for playing Guess The Reptile!");
            endGame = true;              
        }
        }
    }
    
    private boolean guessName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Input your guess: ");
        String response = scan.nextLine();
        if(response.equals(myReptiles[i].getName())){
            System.out.println("Your guess was correct! The reptile was a " + myReptiles[i].getName() + ".");
            return true;
        }
        else{
            System.out.println("Wrong!");
            return false;
        }
    } 
    
    private void shuffle(){        
        for(int i = 0; i < 11; i++){
            int indexRank = (int)(Math.random()*11);
            AbstractReptile tempRank = myReptiles[i];
            myReptiles[i] = myReptiles[indexRank];
            myReptiles[indexRank] = tempRank;
        }
    }
    
    public void printArray(){     
        for(int i = 0; i < 11; i++){
            System.out.println(myReptiles[i].getName());
        }
    }
}
