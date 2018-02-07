/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zacherl008_reptiles;

/**
 *
 * @author kzacherl
 */
public class Monitor extends LizardsWithLegs {
  public Monitor(){
        super("Monitor");
    }
    
    @Override
    public String clue() {
        return "I can be poisonous!";
    }  
}
