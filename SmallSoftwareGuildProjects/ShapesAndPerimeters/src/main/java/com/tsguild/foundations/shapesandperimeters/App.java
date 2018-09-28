/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.shapesandperimeters;

/**
 *
 * @author austinmann
 */
public class App {
    
    public static void main(String[] args) {
        
        
        Shape circle = new Circle();
        ((Circle)circle).setRadius(10);
        
        System.out.println("Radius is: " + ((Circle)circle).getRadius());
        System.out.println("Perimeter (circumference) is: " + ((Circle)circle).getPerimeter());
        System.out.println("Area is: " + circle.getArea());
        
        Shape square = new Square();
        ((Square)square).setLength(10);
        
        System.out.println("Length is: " + ((Square)square).getLength());
        System.out.println("Perimeter is: " + square.getPerimeter());
        System.out.println("Area is: " + square.getArea());
        
        Shape rectangle = new Rectangle();
        ((Rectangle)rectangle).setLength(10);
        ((Rectangle)rectangle).setHeight(20);
        
        System.out.println("Length is: " + ((Rectangle)rectangle).getLength());
        System.out.println("Height is: " + ((Rectangle)rectangle).getHeight());
        System.out.println("Perimeter is: " + rectangle.getPerimeter());
        System.out.println("Area is: " + rectangle.getArea());
        
        Shape triangle = new Triangle();
        ((Triangle)triangle).setLength(10);
        
        System.out.println("Length is: " + ((Triangle)triangle).getLength());
        System.out.println("Perimeter is: " + triangle.getPerimeter());
        System.out.println("Area is: " + triangle.getArea());
    } 
}
