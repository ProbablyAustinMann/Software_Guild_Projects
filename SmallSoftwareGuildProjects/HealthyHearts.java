/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basicprogrmingconcepts;
import java.util.Scanner;
/**
 *
 * @author austinmann
 */
public class HealthyHearts {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("What is your age? ");
        float age = inputReader.nextFloat();
        
        if (age > 0) {
           float rate = 220 - age;
           System.out.println("Your maximum heart rate should be " + rate + " beats per minute.");
           
           if (rate > 0) {
               
               float bottomEnd = (float) (rate * .5);
               float topEnd = (float) (rate * .85);
               
               System.out.println("Your target HR zone is between " + bottomEnd + " - " + topEnd + "beats per minute.");
               
               
           }
            
        }
        
    }
    
}
