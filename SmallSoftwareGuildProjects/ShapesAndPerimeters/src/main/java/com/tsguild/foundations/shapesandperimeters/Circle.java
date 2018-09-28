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
public class Circle implements Shape {
    
    private float radius;
    
    public float getRadius() {
        return radius;
    }
    
    public void setRadius(float radius) {
        this.radius = radius;
    }
    
    public float getPerimeter() {
           
    return getRadius() * 2 * 3.1415926f;
    }
    
    
    public float getArea() {
    return getRadius() * getRadius() * 3.1415926f;
        
    }
}
