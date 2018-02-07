package zacherl008_ica1_tictactoe2;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zacherl008
 */
public class Player {
    public String name;
    private char xo;
    
    public Player(String name, char xo){
        this.name = name;
        this.xo = xo;
        
    }
    
    public String getName(){
        return name;
    } 
    
    public char getXO(){
        return xo;
    }
    
    public int [] makeMove(){
        Scanner scan = new Scanner(System.in);
        h.ps (name + " what row would you like to place your " + xo + ": ");
        int row = scan.nextInt();
        h.ps (name + " what column would you like to place your " + xo + ": ");
        int col = scan.nextInt();
        int [] myArr = {row,col};
        
        return myArr;
    }
}
