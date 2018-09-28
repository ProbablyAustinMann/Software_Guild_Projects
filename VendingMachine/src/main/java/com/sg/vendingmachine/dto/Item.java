/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

import java.util.Objects;

/**
 *
 * @author austinmann
 */
public class Item {
    
    private String machineNumber;
    private String name;
    private String price;
    private String numberInInventory;

    public String getMachineNumber() {
        return machineNumber;
    }

    public Item(String machineNumber) {
        this.machineNumber = machineNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumberInInventory() {
        return numberInInventory;
    }

    public void setNumberInInventory(String numberInInventory) {
        this.numberInInventory = numberInInventory;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.machineNumber);
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.price);
        hash = 31 * hash + Objects.hashCode(this.numberInInventory);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.numberInInventory, other.numberInInventory)) {
            return false;
        }
        if (!Objects.equals(this.machineNumber, other.machineNumber)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return machineNumber +  "  " + name;  
    }

    
}
