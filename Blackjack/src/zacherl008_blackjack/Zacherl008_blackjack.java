/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zacherl008_blackjack;

import java.util.Scanner;

/**
 *
 * @author zacherl008
 */
public class Zacherl008_blackjack {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("How many players?: ");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        Dealer dealer = new Dealer(number);
        dealer.playHand();
        dealer.askNewGame();
    }   
}
