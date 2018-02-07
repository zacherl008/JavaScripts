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
public class Tortoise extends Testudines{
    public Tortoise(){
        super("Tortoise");
    }
    
    @Override
    public String clue() {
        return "I live on land!";
    }
    
}
