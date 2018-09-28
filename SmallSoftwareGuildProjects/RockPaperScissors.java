/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basicprogrmingconcepts;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author austinmann
 */
public class RockPaperScissors {
    public static void main(String[] args) {
        int roundAmount = 1, roundNumber, win = 0, loss = 0, tie = 0;

        
        Scanner inputReader = new Scanner(System.in);
        Random randomizer = new Random();
        
        while (roundAmount != 0) {
            
        System.out.println("How many rounds would you like to play? (Between 1 and 10)");
        roundAmount = inputReader.nextInt();
        
        
        if (roundAmount > 0 && roundAmount < 10) {
        for (roundNumber = -1; roundNumber < roundAmount; roundNumber++) {
            
            System.out.println("Rock, Paper, or Scissors?");
            
            String userRPS = inputReader.nextLine();         
            
            int computerRPS = randomizer.nextInt(4);
            
            if (userRPS.equals ("rock")) {
                if (computerRPS == 1) {
                    System.out.println("Rock And Rock! Tie!");
                    tie++;
                }
                else if (computerRPS == 2) {
                    System.out.println("Paper beats Rock! You lose!");
                    loss++;
                }
                else {
                    System.out.println("Rock beats Scissors! You win!");
                    win++;
                }
                
            } else if (userRPS.equals ("paper")) {
                if (computerRPS == 1) {
                    System.out.println("Paper beats Rock! You Win!");
                    win++;
                }
                else if (computerRPS == 2) {
                    System.out.println("Paper and Paper! Tie!");
                    tie++;
                }
                else {
                    System.out.println("Scissors beats paper! You Lose!");
                    loss++;
                }
            
            } else if (userRPS.equals ("scissors")) {
                if (computerRPS == 1) {
                    System.out.println("Rock beats Scissors! You lose!");
                    loss++;
                }
                else if (computerRPS == 2) {
                    System.out.println("Scissors beats Paper! You Win!");
                    win++;
                }
                else {
                    System.out.println("Scissors and Scissors! Tie!");
                    tie++;
                }
            } 
            
            
        }  
        System.out.println("You had " + win + " wins, " + loss + " losses, and " + tie + " ties.");
        
        if (win > loss) {
            System.out.println("You win! This time...");

        } else if (loss > win) {
            System.out.println("You lose! Never forget, the house always wins.");
        
        } else if (win == loss) {
            System.out.println("It's an overall tie!");
        }  
        System.out.println("Play again? (y/n)");
        String playAgain = inputReader.nextLine();
        
        if (playAgain.equals("n")) {

            System.out.println("Thank You for playing!");
            roundAmount = (roundAmount - roundAmount);
            
        } else {
            win = (win - win);
            loss = (loss - loss);
            tie = (tie - tie);
        }
        
        } else{
            System.out.println("Why are you like this?");
        }
    }
    
    }
}

        
    
    