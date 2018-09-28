/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basicprogrmingconcepts;

/**
 *
 * @author austinmann
 */
public class SummativeSums {
    public static void main(String[] args) {
        int[] array1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] array2 = { 999, -60, -77, 14, 160, 301 };
        int[] array3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
        140, 150, 160, 170, 180, 190, 200, -99 };
        System.out.println("#1 Array Sum: " + addArray1());
        System.out.println("#2 Array Sum: " + addArray2());
        System.out.println("#3 Array Sum: " + addArray3());
        
    }
    private static int addArray1() {
        int sum1 = 0, sum3 = 0;
        
        int[] array1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        
        for (int i = 0; i < array1.length; i++) {
           sum1 += array1[i];
        }
        return sum1;
    }
    private static int addArray2() {
        int sum2 = 0;
        
        int[] array2 = { 999, -60, -77, 14, 160, 301 };
        
        for (int i = 0; i < array2.length; i++) {
            sum2 += array2[i];
        }
         return sum2;

    }
    private static int addArray3() {
        int sum3 = 0;
        
        int[] array3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
        140, 150, 160, 170, 180, 190, 200, -99 };
        
        for (int i = 0; i < array3.length; i++) {
            sum3 += array3[i];
        }
       return sum3;
    }
  }
