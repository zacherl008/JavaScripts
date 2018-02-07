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
public class Card {
    private final String rank;
    private final String suit;
    
    public Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank(){
        return rank;
    }
    
    public String getSuit(){
        return suit;
    }
}

