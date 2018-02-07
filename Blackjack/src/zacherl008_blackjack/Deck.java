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
public class Deck {
    
    private Card[] myCards = new Card[52];
    private int nextCard = 0;
    
    String [] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    String [] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    
    Deck(){
        initDeck();
        shuffle();
    }
    
    public Card dealNextCard(){
        if (nextCard > 51){
            shuffle();
            nextCard = 0;
        }
        return myCards[nextCard++];
    } 
    
    private void initDeck(){
        for(int i = 0; i < 52; i++){
            myCards[i] = new Card(ranks[i%13], suits[i/13]);

        }
    }
    
    public void printDeck(){
        for(int i = 0; i < 52; i++){
            System.out.println(myCards[i].getRank() + " of " +  myCards[i].getSuit());
        }
    }
    
    private void shuffle(){
        
    }
}
