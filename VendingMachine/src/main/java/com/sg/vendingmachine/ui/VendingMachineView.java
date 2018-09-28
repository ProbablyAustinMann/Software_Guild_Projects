/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Item;
import java.util.List;

/**
 *
 * @author austinmann
 */
public class VendingMachineView {
    
    UserIO io;
    
    public VendingMachineView(UserIO io) {
        this.io = io;
    }
    
    //method I used to initially stock the machine
    public Item getNewItemInfo() {
        String machineNumber = io.readString("Machine Possition");
        String name = io.readString("Name");
        String price = io.readString("Price");
        String numberInInventory = io.readString("Inventory Number");
        Item currentItem = new Item(machineNumber);
        currentItem.setName(name);
        currentItem.setPrice(price);
        currentItem.setNumberInInventory(numberInInventory);
        return currentItem;
    }
    
    public void addSuccessBanner() {
        io.readString("Item successfully stocked.");
    }
    
    //method for displaying the menu
    public void displayMenuView(List<Item> itemList) {
        for (Item currentItem : itemList) {
            io.print(currentItem.getMachineNumber() + ": " + currentItem.getName()
            + " - " + currentItem.getPrice());
        }
        io.readString(" ");
    }
    
    public void displayGreetingBanner() {
        io.print("Welcome! Check out our fantastic selection!");
        io.print("===========================================");
        // I used the integer below to stock the machine
        // return io.readInt("");
    }
    
    //takes money, or allows user to exit program
    public String takeUserMoney() {
       return io.readString("Please insert your money and make a selection, or type 'Exit' to exit.");
    }
    
    public void displayErrorMessage(String errorMessage) {
        io.print("=== ERROR ===");
        io.print(errorMessage);
    }
    
    //gets selection and vends item.
    //or tells user they don't have enough money, and returns their money
    public String getUserSelection() {
        return io.readString("Please choose an item");
    }
    
    public void vendUserItem(Item item) {
        if (item != null) {
            io.print("Enjoy your " + item.getName() + "!");
        }
    }
    
    
    
    
    
    
    
}
