/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zacherl008_blackjack;

import java.util.Scanner;

/**
 *
 * @author zacherl008
 */
public class Dealer {
    Deck gameDeck = new Deck();
    Hand dealerHand = new Hand();
    Player[] players;
    
    public Dealer(int numOfPlayers){
        initPlayers(numOfPlayers);
    }
    
    private void initPlayers (int numOfPlayers){
        players = new Player[numOfPlayers];
        for(int i = 0; i < players.length; i++){
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter your name: ");
            String name = scan.next();
            players[i] = new Player(name);
        }
    }
    
    public void playHand(){
        dealOutOpeningHand();
        playOutPlayerHands();
        playOutDealerHand();
        declareWinner();
    }
    
    public void dealOutDealerHand(){
        for (int i = 0; i <2; i++){
            dealerHand.addCard(gameDeck.dealNextCard());
        }
    }
    public void dealOutOpeningHand(){
        dealOutDealerHand();        
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < players.length; j++)
            {
                players[j].getHand().addCard(gameDeck.dealNextCard()); 
            }       
        }       
    }
    
    public void playOutPlayerHands(){
        for (int i = 0; i < players.length; i++){
            boolean continueLoop = true;
            players[i].printMyHand();
            while (continueLoop){
                Scanner scan = new Scanner(System.in);
                if(players[i].getHand().checkStartBlackjack() == true){
                    break;
                }
                System.out.print(players[i].getName() + ", enter 'hit' to hit and 'stand' to stand: ");
                String response = scan.next();
                if (response.equals("hit")){
                    players[i].getHand().addCard(gameDeck.dealNextCard());
                    players[i].printMyHand();
                    if (players[i].getHand().checkScore() == false){
                        break;
                    }
                }
                else if (response.equals("stand")){
                    continueLoop = false;
                    System.out.print("\n");
                }
                else{
                    System.out.print("You have entered an invalid response.\n");                      
                }
            }
        }     
    }
    
    public void playOutDealerHand(){
        System.out.println("Dealer hand is: ");
        dealerHand.printHand();
        boolean continueLoop = true;
        if (dealerHand.checkStartBlackjack() == true){
            continueLoop = false;
        }
        while(continueLoop == true){
            if (dealerHand.getScore() < 16){
                System.out.println("Dealer score is: " + dealerHand.getScore() + ". Dealer must hit.");
                dealerHand.addCard(gameDeck.dealNextCard());
                System.out.println("Dealer hand is: ");
                dealerHand.printHand();
                dealerHand.checkScore();
            }
            else{
                continueLoop = false;
                System.out.print("\n");
            }
        } 
    }
    public void declareWinner(){
        for (int i = 0; i < players.length; i++){
            int playerScore = players[i].getHand().getScore();
            int dealerScore = dealerHand.getScore();
            System.out.print("Player " + players[i].getName() + ": ");
            if (playerScore > 21){
                System.out.println("Your score is " + playerScore + ". You have busted.");
            }
            else if (playerScore == 21 && dealerScore != 21){
                System.out.println("Blackjack! You win.");
            }    
            else if (players[i].getHand().checkFiveCard() == true){
                System.out.println("Five card charlie! You win.");
            }
            else if (playerScore == 21){
                System.out.println("You and the dealer both have blackjack. You lose.");
            }
            else if (playerScore > dealerScore){
                System.out.println("Your score is " + playerScore + " and the dealer's score is " + dealerScore + ". You win.");
            }
            else if (playerScore == dealerScore){
                System.out.println("Your score is " + playerScore + " and the dealer's score is " + dealerScore + ". It is a tie and you lose.");
            }
            else if (playerScore < dealerScore){
                System.out.println("Your score is " + playerScore + " and the dealer's score is " + dealerScore + ". You lose.");
            }
        }    
    }
   
    private void clearHands(){
        for(int i = 0; i < players.length; i++){
            players[i].clearHand();
        }
        dealerHand = new Hand();
    }
    
    public void askNewGame(){
        System.out.println("Would you like to play again? Enter yes or no: ");
        Scanner scan = new Scanner(System.in);
        String response = scan.next();
        System.out.println();
        
        if (response.equals("yes")){
            clearHands();
            playHand();
            askNewGame();
        }
    }
}
