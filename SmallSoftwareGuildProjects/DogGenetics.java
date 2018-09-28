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
public class DogGenetics {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        Random randomizer = new Random();
        
        int[] array = new int[5];
        
        System.out.println("What is your dog's name? ");
        String name = userInput.nextLine();
        
        for (int i = 0; i <= 4; i++) {
            switch (i) {
                case 0:
                    array [i] = randomizer.nextInt((100) + 1);
                    break;
                case 1:
                    array [i] = randomizer.nextInt(((100) + 1) - (array[0]));
                    break;
                case 2:
                    array [i] = randomizer.nextInt(((100) + 1) - (array[0] + array[1]));
                    break;
                case 3:
                    array [i] = randomizer.nextInt(((100) + 1) - (array[0] + array[1] + array[2]));
                    break;
                default:
                    array [i] = ((100) - (array[0] + array[1] + array[2] + array[3]));
            }
            
            
            
        }
        
        System.out.println("Well then, I have this highly reliable report on " + name + "'s prestigious background right here.");
        System.out.println(name + " is:");
        System.out.println(array[0] + "% Akita Inu");
        System.out.println(array[1] + "% German Shepherd");
        System.out.println(array[2] + "% Bull Terrier");
        System.out.println(array[3] + "% Doberman");
        System.out.println(array[4] + "% Greyhound");
        System.out.println("Wow. That's QUITE the dog!");
        
        
    }
    
}
