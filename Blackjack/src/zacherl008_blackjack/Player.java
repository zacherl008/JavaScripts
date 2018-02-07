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
public class Player {
    private Hand myHand = new Hand();
    private String name;
    
    public Player(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    public Hand getHand(){
        return myHand;
    }
    
    public void clearHand(){
        myHand = new Hand();
    }
    
    public void printMyHand(){
        System.out.println(name + "'s Hand: ");
        myHand.printHand();
    }
}
