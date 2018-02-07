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
public abstract class NoLegsSlither extends NoLegs {
    public NoLegsSlither(String name) {
        super(name);
    }
    
    public String SubsetClue(){
        return "I slither!";
    }
    
}
