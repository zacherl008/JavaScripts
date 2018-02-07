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
    private int score;
    boolean usedAce = false;
    
    public Hand(){}
    
    public boolean addCard(Card nextCard){
        if(cardCount<5){
            myHand[cardCount] = nextCard;
            cardCount++;
            getScore();
            return true;
        }
        else{
            System.out.println("You already have five cards!");
            return false;
        }
    }
    
    public int getScore(){
        score = 0;
        for (int i = 0; i < cardCount; i++){
            if (myHand[i].getRank().equals("Jack")){
                score += 10;
            }
            else if (myHand[i].getRank().equals("Queen")){
                score += 10;
            }
            else if (myHand[i].getRank().equals("King")){
                score += 10;
            }
            else if (myHand[i].getRank().equals("Ace")){
                if (score > 10){
                    score += 1;
                    usedAce = true;
                }
                else{
                    score += 11;
                }
            }
            else{
                score += Integer.parseInt(myHand[i].getRank());
            }
        }
        return score;
    }
    
    public boolean checkScore(){
        if (score == 21){
            System.out.println("BLACKJACK!\n");
            return false;
        } 
        if (cardCount == 5 && score < 22){
            System.out.println("Five card Charlie!");
            return false;
        }
        if (score > 21){
            if (usedAce == false && checkAce() == true){
                usedAce = true;
            }
            else{
                System.out.println("BUSTED!\n");
                return false;
            }
        }
        return true;
    }
    
    public void printHand(){
        String message = "| ";
        for(int i = 0; i < cardCount; i++){
            message += myHand[i].getRank() + " of " + myHand[i].getSuit() + " | ";
        }
        message += "\nScore: " + score;
        System.out.println(message);
    }

    public boolean checkStartBlackjack() {
        if (score == 21){
            System.out.println("Natural blackjack!\n");
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean checkFiveCard() {
        if (cardCount == 5 & score < 22){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean checkAce(){
        for (int i = 0; i< cardCount; i++){
            if(myHand[i].getRank().equals("Ace")){
               System.out.println("Your ace is now a 1.");
               score += -10;
               System.out.println("New score is: " + score);
               return true;   
            }   
        }    
        return false;
    } 
}
