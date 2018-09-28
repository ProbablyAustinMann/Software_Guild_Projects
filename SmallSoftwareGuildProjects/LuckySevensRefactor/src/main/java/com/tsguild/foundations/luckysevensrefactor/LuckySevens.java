/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.luckysevensrefactor;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author austinmann
 */
public class LuckySevens {
    
    public void rollDice() {
        
        Scanner inputReader = new Scanner (System.in);
        
        System.out.println("How many dollars do you have?");
        int dollars = inputReader.nextInt();
        int rollCounter = 0;
        int max = dollars;
        int rollMax = 0;
        
        while (dollars > 0) {
            roll();
            rollCounter++;
            
            if (roll() == 7) {
                dollars = dollars + 4;
            } else {
                dollars = dollars - 1;
            }
            if (dollars > max) {
                max = dollars;
                rollMax = rollCounter;
            }
            
        }
        System.out.println("You went broke after " + rollCounter + " rolls.");
        System.out.println("You should have quit after " + rollMax + " rolls when you had " + max + " dollars.");
    }
    static int roll() {
        Random dieRoller = new Random();
        int die1 = dieRoller.nextInt(6) + 1;
        int die2 = dieRoller.nextInt(6) + 1;
        return die1 + die2;
        
        
    }

    
}
