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
public class Turtle extends Testudines{
    public Turtle(){
        super("Turtle");
    }
    
    @Override
    public String clue() {
        return "I live in the water!";
    }
    
}
