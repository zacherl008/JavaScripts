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
public abstract class AbstractReptile {
    private String name;
    
    public AbstractReptile (String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
       
    public abstract String clue();
    
    public abstract String FamilyClue();
    
    public abstract String SubsetClue();
}
