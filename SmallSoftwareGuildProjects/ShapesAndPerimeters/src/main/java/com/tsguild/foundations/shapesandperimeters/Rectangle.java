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
public class Rectangle implements Shape {
    
    private float length;
    private float height;

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
    

    public float getArea() {
        return (getLength() * getHeight());
    }


    public float getPerimeter() {
        return (getLength() * 2) + (getHeight() * 2);
    }
    
}
