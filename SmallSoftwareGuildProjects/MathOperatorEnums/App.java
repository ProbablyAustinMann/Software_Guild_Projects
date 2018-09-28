/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.enums.mathoperators;

import java.io.PrintStream;


/**
 *
 * @author austinmann
 */
public class App {
    
    public static void main(String[] args) {
       
        EnumMath math = new EnumMath(); 
        
        int op1 = 20;
        int op2 = 2;
        
        System.out.println(math.calculate(MathOperators.PLUS, op1, op2));
        System.out.println(math.calculate(MathOperators.MINUS, op1, op2));
        System.out.println(math.calculate(MathOperators.MULTIPLY, op1, op2));
        System.out.println(math.calculate(MathOperators.DIVIDE, op1, op2));

        
    }
    
    public int calculate(MathOperators operator, int operand1, int operand2) {
            
            
            
            switch (operator) {
                case PLUS:
                    return operand1 + operand2;
                case MINUS:
                    return operand1 - operand2;
                case MULTIPLY:
                    return operand1 * operand2;
                case DIVIDE:
                    return operand1 / operand2;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    
}
