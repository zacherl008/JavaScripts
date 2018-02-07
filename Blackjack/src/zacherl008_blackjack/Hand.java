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
public class Hand {
    private Card[] myHand = new Card [5];
    private int cardCount = 0;
    private int score = 0;
    
    public Hand(){}
    
    public boolean addCard(Card nextCard){
        if(cardCount<5){
            myHand[cardCount] = nextCard;
            cardCount++;
            score += nextCard.getValue();
            return true;
        }
        else{
            System.out.println("You already have five cards!");
            return false;
        }
    }
    
    public int getScore(){
        return score;
    }
    
    public boolean checkScore(){
        if (score == 21){
            System.out.println("You got 21!");
        } 
        return score < 22;
    }
    
    public void printHand(){
        String message = "";
        for(Card thisCard : myHand){
            message += thisCard.getRank() + "of" + thisCard.getSuit() + " | ";
        }
        message += "\n Your score: " + score;
        System.out.println(message);
    }
}
