/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.golfscorecard.golfscorecard;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author austinmann
 */
public class Program {
    public static void main(String[] args) {
        boolean playAgain = false;
        
        do{
           //call method to record round of golf..
           
           recordAndDisplayRound();
           
           //prompt to play again
           
           playAgain =getUserYesNo ("Would you like to play another round?");
           
        } while (playAgain);
    }

    private static boolean getUserYesNo(String prompt) {
        Scanner input = new Scanner(System.in);
        String inputFromUser;
        System.out.println(prompt);
        System.out.println("Enter (y)es or (n)o: ");
        inputFromUser = input.nextLine();
        
       // inputFromUser = null;
        
        if ("yes".equalsIgnoreCase(inputFromUser) || 
                (input) != null && 
                inputFromUser.toLowerCase().startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }
    
    private static void recordAndDisplayRound() {
        
        boolean inputScores = false;
        boolean fullCourse = false;
        int numberOfHoles;
        int [] scores;
        
        fullCourse = getUserYesNo("Would you like to play 18? "
                                 + "(no or default is 9)");
        inputScores = getUserYesNo("Would you like to input scores "
                                  + "or have me record for you?");
        
        if (fullCourse == true) {
            numberOfHoles = 18;
        } else {
            numberOfHoles = 9;
        }
       // scores = new int [numberOfHoles];
       //we could have created an array here
        
        if (inputScores) {
            scores = getScoresFromUser(numberOfHoles);
        } else {
            scores = getRandomScores(numberOfHoles);
        }
        printScores(scores);

    }
    
    private static int[] getScoresFromUser(int length) {
       int[] arrayOfScores = new int[length];
       
       return arrayOfScores;
    
    }
    
    private static int [] getRandomScores(int length) {
        int [] arrayOfScores = new int[length];
        Random rng = new Random();
        
        for (int i = 0; i < arrayOfScores.length; i++) {
            arrayOfScores[i] = rng.nextInt(8) + 1;
        }
        
        return arrayOfScores;
    }
    private static void printScores(int[] values) {
        System.out.println("Here are your scores for the round: ");
        String front9ScoreOutput = "| ";
        String back9ScoreOutput = "| ";
        String front9 = "| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |";
        String back9 = "| 10 | 11 | 12 | 13 | 14 | 15 | 16 | 17 | 18 |";
        String seperator = 
                       "----------------------------------------------";
        final int FRONT_NUMBER = 9;
        int sum = 0;
        /*
        for (int i = 0; i < 9; i++) {
            front9ScoreOutput += values[i];
            front9ScoreOutput += " | ";
            
        }
        for (int i = 10; i < 18; i++){
            back9ScoreOutput += 
            
        }
*/
        for (int i = 0; i < values.length; i++) {
            if (i < FRONT_NUMBER) {
                front9ScoreOutput += values[i];
                front9ScoreOutput += " | ";   
            } else {
                back9ScoreOutput += values [i];
                back9ScoreOutput += " | ";
            }
            sum += values[i];
            
        }
        
        System.out.println(seperator);
        System.out.println(front9);
        System.out.println(seperator);
        System.out.println(front9ScoreOutput);
        System.out.println(seperator);
        if (values.length > FRONT_NUMBER) {
            System.out.println(back9);
            System.out.println(seperator);
            System.out.println(back9ScoreOutput);
            System.out.println(seperator);
        } 
        
        System.out.println("Your total score for this round is:");
        System.out.println(sum);
        
    }
    
}
