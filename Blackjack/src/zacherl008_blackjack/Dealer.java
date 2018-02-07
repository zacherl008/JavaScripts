/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zacherl008_blackjack;

/**
 *
 * @author zacherl008
 */
public class Dealer {
    
    Deck gameDeck = new Deck();
    Hand dealerHand = new Hand();
    Player[] players;
    
    public Dealer(int numOfPlayers){
        players = new Player[numOfPlayers];
    }
    
    public void playHand(){
        dealOutOpeningHand();
        playOutPlayerHands();
        playOutDealerHand();
        declareWinner();
    }
    public void dealOutOpeningHand(){
        //outside loop that goes twice
        //inside loop to go through palyers
        //gamedeck. deck .dealnext card
        //deal next carcd from game deck and go outside into other loops to give all palyers a second card
        //print hands
                                        
    }
    
    public void playOutPlayerHands(){
        //print player hands of current players
        //hit or stand using scanner
        //
                
    }
    
    public void playOutDealerHand(){
        //if value > 15 then stand, if not hit 
        
    }
    public void declareWinner(){
        //each player, getScore(),DQ if more than 22
        //if less than 22 get(score) do player.getScore vs dealer.getScore
        //dealer wins tie
    }
}
