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
public class Square implements Shape {
    private float length;
    
    public float getLength() {
        return length;
    }
    public void setLength(float length) {
        this.length = length;
    }

    public float getPerimeter() {
        return getLength() * 4;  
    }

    public float getArea() {
        return getLength() * getLength();
    }

    
    
}
