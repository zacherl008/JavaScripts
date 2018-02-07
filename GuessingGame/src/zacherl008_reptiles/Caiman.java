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
public class Caiman extends Crocodilians{
    public Caiman(){
        super("Caiman");
    }
    
    @Override
    public String clue() {
        return "I am smaller than my relatives!";
    }
}
